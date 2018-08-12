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
		// Future��ü�� get �޼ҵ�� �۾��� �Ϸ�Ǿ� ���� �ޱ� ������ Block�Ǵ� ������ �ִ�. 
		// �̸� �ذ��ϱ����� ������ Future �۾��� �񵿱�� ó�����־� ���ɿ� ������ ��ġ�� �ʾƾ��Ѵ�.
		// future�۾� ������ ������ future�� ���� ó���� call back�� �̿��� ó���� ���� ó���� �ִ�ȭ �Ѵ�.
		/////////////////////////////////////////////////////////////////////
		CompletableFuture
		.runAsync(()->{ //Runnable Lambda [Async Task] �񵿱� �۾��� �ڵ�
			try {
				Thread.sleep(1000);
				String result = future1.get();
				System.out.println(result);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		})
		.thenRun(()->{ //Runnable Lambda [Call Back] // �۾� �Ϸ��� �ݹ� �޼ҵ� 
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
	
	public static void endTask(String result) { // end interrupt �޴� �޼ҵ�
		System.out.println(result);
	}
	
}
