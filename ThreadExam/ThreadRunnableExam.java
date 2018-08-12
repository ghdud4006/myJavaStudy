import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunnableExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �⺻������ ����
		BasicThread basicThread = new BasicThread();
		basicThread.start();
		
		// ���ʺ� ����
		RunnableThread runnableThread = new RunnableThread();
		Thread thread = new Thread(runnableThread);
		thread.start();
		
		try {
			basicThread.join(); //�⺻ ������ ���� ��ٸ�
			System.out.println("Basic Thread is terminated");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			thread.join(); // ���ʺ� ���� ��ٸ�
			System.out.println("Runnable Thread is terminated");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 2�� ���
		try {
			Thread.sleep(200);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(runnableThread);
		executorService.shutdown();
		
	}

}
/**
 * Thread�� ����� �޾� ���
 * @author task
 *
 */
class BasicThread extends Thread {
	
	public void run() {
		System.out.println("Basic Thread");
	}
	
}

/**
 * Runnable�� �������̽� ����
 * => �ٸ� Ŭ������ ��� ���� �� �ִ�. 
 * @author task
 *
 */
class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable Thread");
	}
	
}


