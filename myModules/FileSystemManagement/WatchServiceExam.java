import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;


/**
 * WatchService 
 * - 설정 디렉토리 내부에서 파일 생성/삭제/수정등 변화를 감시 
 * @author task
 *
 */
public class WatchServiceExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start Watch Service");
		
		Thread watchServiceThread = new WatchServiceThread();
		watchServiceThread.start();
		
	}
	
}

class WatchServiceThread extends Thread {
	WatchService watchService = null;
	
	@Override
	public void run() {
		try {
			// watch service 인스턴스 생성
			watchService = FileSystems.getDefault().newWatchService();
			// 관리 대상 directory path 객체 생성
			Path dir = Paths.get("D:/0my/testDir");
			// 해당 directory에 watchService 등록
			dir.register(watchService, 
					StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			// => 변경이 발생하면 WatchEvent 발생
			// => 해당 이벤트 정보를 가진 WatchKey를 생성하여 Queue에 넣어줌
			
			while(true) {
				// 무한 루프를 돌다가 변화 발생시 WatchKey를 얻음 
				WatchKey watchKey = watchService.take();
				// List로 반환되는 이유는 한 디렉토리에서 여러 파일이 동시에 변화할 수 있기 때문
				// WatchEvent는 한 파일당 하나 발생 
				List<WatchEvent<?>> list = watchKey.pollEvents();
				
				// 발생이벤트 리스트들을 순회하며
				for(WatchEvent<?> watchEvent : list) {
					Kind<?> kind = watchEvent.kind();
					Path path = (Path) watchEvent.context();
					
					// 해당이벤트의 종류에 따라 작업 처리
					if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
						System.out.println("파일 생성됨");
					} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
						System.out.println("파일 삭제됨");
					} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
						System.out.println("파일 수정됨");
					} else if (kind == StandardWatchEventKinds.OVERFLOW) {
						
					}
					
				}
				
				boolean valid  = watchKey.reset();
				if(!valid) {
					break;
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(watchService != null) watchService.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
