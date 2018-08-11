import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Server {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = null;
			HashMap<String, Object> userWritersMap = new HashMap<String, Object>();
			
			server = new ServerSocket(10001);
			
			while(true) {
				// 클라이언트 연결대기
				System.out.println("Waiting to connect  . . .");
				Socket socket = server.accept(); // 연결 시  accept함수가 클리언트에 대한 소켓 생성
				ChatThread chatThread = new ChatThread(socket, userWritersMap);
				chatThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}

class ChatThread extends Thread {
	
	Socket socket = null;
	HashMap<String, Object> userWritersMap = null;
	BufferedReader reader = null;
	String userId = null;
	boolean initFlag = false;
	
	public ChatThread(Socket socket, HashMap<String, Object> userWritersMap) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.userWritersMap = userWritersMap;
		
		try {
			BufferedWriter userWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 최초 연결시 유저 아이디 받음 
			this.userId = reader.readLine(); 
			broadcast(userId+" joins.");
			System.out.println(userId+" joins.");
			
			// hashMap에 유저아이디(key), 해당 소켓 writer obj(value) 삽입
			synchronized(userWritersMap) { // 멀티스레드 동기화
				userWritersMap.put(userId, userWriter);
			}
			
			initFlag = true;
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		try {
			String line = null;
			while((line = reader.readLine()) != null) {
				if(line.equals("/quit")) {
					break;
				} else if(line.indexOf("/to")==0) {
					sendWhisperMsg(line);
				} else {
					broadcast(userId+" : "+line);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				synchronized(userWritersMap) { // 해당 유저 데이터 삭제
					userWritersMap.remove(userId);
				}
				if(socket != null) {
					socket.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	
	}
	
	public void sendWhisperMsg (String msg) { // 1:1 귓속말 보내기
		// 보낼 아이디 부분 파싱
		int idBeginIndex = msg.indexOf(" ") + 1;
		int idEndIndex = msg.indexOf(" ",idBeginIndex);
		if(idEndIndex != -1) {
			String to = msg.substring(idBeginIndex, idEndIndex);
			String text = msg.substring(idEndIndex+1)+"\n";
			Object obj = userWritersMap.get(to);
			// 해당 아이디 클라이언트에게 write
			if(obj != null) {
				BufferedWriter writer = (BufferedWriter) obj;
				try {
					writer.write(text);
					writer.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public void broadcast (String msg) { // 채팅방 전체 브로드 캐스트
		synchronized(userWritersMap) {
			Collection<Object> collection = userWritersMap.values();
			Iterator<?> it = collection.iterator();
			while(it.hasNext()) {
				BufferedWriter writer = (BufferedWriter)it.next();
				try {
					writer.write(msg+"\n");
					writer.flush();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
