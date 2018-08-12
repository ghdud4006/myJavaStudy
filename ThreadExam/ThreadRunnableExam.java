import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRunnableExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 기본스레드 실행
		BasicThread basicThread = new BasicThread();
		basicThread.start();
		
		// 러너블 실행
		RunnableThread runnableThread = new RunnableThread();
		Thread thread = new Thread(runnableThread);
		thread.start();
		
		try {
			basicThread.join(); //기본 스레드 종료 기다림
			System.out.println("Basic Thread is terminated");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			thread.join(); // 러너블 종료 기다림
			System.out.println("Runnable Thread is terminated");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 2초 대기
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
 * Thread는 상속을 받아 사용
 * @author task
 *
 */
class BasicThread extends Thread {
	
	public void run() {
		System.out.println("Basic Thread");
	}
	
}

/**
 * Runnable은 인터페이스 구현
 * => 다른 클래스를 상속 받을 수 있다. 
 * @author task
 *
 */
class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable Thread");
	}
	
}


