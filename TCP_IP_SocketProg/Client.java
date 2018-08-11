import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	/**
	 * Client code
	 * @param args
	 * args[0] // user id
	 * args[1] // server ip addr
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("err : args");
			System.exit(1);
		}
		Socket socket = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		boolean endFlag = false;
		BufferedReader keyboard = null; // 키보드 입력
		
		try {
			socket = new Socket(args[1], 10001); // ip addr, port num
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			// 최초 유저 아이디 전송
			writer.write(args[0]+"\n");
			writer.flush();
			
			// 입력 스레드 생성
			InputThread inputThread = new InputThread(socket, reader);
			inputThread.start();
			
			//키보드 입력
			String line = null;
			while((line = keyboard.readLine()) != null) {
				// 서버로 메시지 전송
				writer.write(line+"\n");
				writer.flush();	
				if(line.equals("/quit")) { // 나가기 인터페이스
					System.out.println("Bye");
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(writer != null) {
					writer.close();
				}
				if(reader != null) {
					reader.close();
				}
				if(keyboard != null) {
					keyboard.close();
				}
			} catch (Exception e2 ) {
				e2.printStackTrace();
			}
		}
		
		
		
	}
	
}

/**
 * read write 같은 스레드에서 하면 블락될 수 있어서 따로 빼놓는다 !!
 * @author task
 *
 */
class InputThread extends Thread {
	
	Socket socket = null;
	BufferedReader reader = null;
	
	public InputThread(Socket socket, BufferedReader reader) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.reader = reader;
	}
	
	public void run() {
		try {
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch (Exception e2 ) {
				e2.printStackTrace();
			}
		}
	}
	
}
