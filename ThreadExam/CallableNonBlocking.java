import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableNonBlocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableClass callableObj1 = new CallableClass("Non-Blocking Task 1");
		CallableClass callableObj2 = new CallableClass("Non-Blocking Task 2");
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		Future<String> future1 = executor.submit(callableObj1); 
		Future<String> future2 = executor.submit(callableObj2); 
		/////////////////////////////////////////////////////////////////////
		// Future객체의 get 메소드는 작업이 완료되어 값을 받기 전까지 Block되는 단점이 있다. 
		// 이를 해결하기위해 각각의 Future 작업을 비동기로 처리해주어 성능에 영향을 끼치지 않아야한다.
		// future작업 이후의 각각의 future에 대한 처리는 call back을 이용해 처리해 병렬 처리를 최대화 한다.
		/////////////////////////////////////////////////////////////////////
		CompletableFuture
		.runAsync(()->{ //Runnable Lambda [Async Task] 비동기 작업할 코드
			try {
				Thread.sleep(1000);
				String result = future1.get();
				System.out.println(result);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		})
		.thenRun(()->{ //Runnable Lambda [Call Back] // 작업 완료후 콜백 메소드 
			CallableNonBlocking.endTask("end 1");
		});
		
		
		
		
		CompletableFuture
		.runAsync(()->{ //Runnable Lambda [Async Task]
			try {
				Thread.sleep(200);
				String result = future2.get();
				System.out.println(result);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		})
		.thenRun(()->{ //Runnable Lambda [Call Back] 
			CallableNonBlocking.endTask("end 2");
		});
		
		
		System.out.println("end code");
		
	}
	
	public static void endTask(String result) { // end interrupt 받는 메소드
		System.out.println(result);
	}
	
}
