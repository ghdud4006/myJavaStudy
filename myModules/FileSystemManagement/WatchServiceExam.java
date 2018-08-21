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
 * - ���� ���丮 ���ο��� ���� ����/����/������ ��ȭ�� ���� 
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
			// watch service �ν��Ͻ� ����
			watchService = FileSystems.getDefault().newWatchService();
			// ���� ��� directory path ��ü ����
			Path dir = Paths.get("D:/0my/testDir");
			// �ش� directory�� watchService ���
			dir.register(watchService, 
					StandardWatchEventKinds.ENTRY_CREATE, 
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			// => ������ �߻��ϸ� WatchEvent �߻�
			// => �ش� �̺�Ʈ ������ ���� WatchKey�� �����Ͽ� Queue�� �־���
			
			while(true) {
				// ���� ������ ���ٰ� ��ȭ �߻��� WatchKey�� ���� 
				WatchKey watchKey = watchService.take();
				// List�� ��ȯ�Ǵ� ������ �� ���丮���� ���� ������ ���ÿ� ��ȭ�� �� �ֱ� ����
				// WatchEvent�� �� ���ϴ� �ϳ� �߻� 
				List<WatchEvent<?>> list = watchKey.pollEvents();
				
				// �߻��̺�Ʈ ����Ʈ���� ��ȸ�ϸ�
				for(WatchEvent<?> watchEvent : list) {
					Kind<?> kind = watchEvent.kind();
					Path path = (Path) watchEvent.context();
					
					// �ش��̺�Ʈ�� ������ ���� �۾� ó��
					if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
						System.out.println("���� ������");
					} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
						System.out.println("���� ������");
					} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
						System.out.println("���� ������");
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
