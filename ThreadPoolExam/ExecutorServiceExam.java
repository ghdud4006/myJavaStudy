import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ExecutorService 인터페이스 구현 객체 Executors 정적메서드를 통해 최대 스레드 개수가 2인 스레드 풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<10; i++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					// 스레드에게 시킬 작업 내용
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName(); //스레드 풀에 있는 해당 스레드 이름 얻기
					System.out.println("[총 스레드 개수 :"+poolSize+"]작업 스레드 이름 : "+threadName);
					
					//일부러 예외 발생 
					int value = Integer.parseInt("예외");
				}
			};
			// 스레드 풀에게 작업 처리 요청 
			executorService.execute(runnable); // return이 없음(runnable), 예외 발생시 스레드 재 생성
			//executorService.submit(callable); // return이 있음(callable), 예외 발생해도 스레드 재 생성하지 않음 
			
			// 콘솔 출력 시간 주기 위해 메인 스레드 0.01초 sleep
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
