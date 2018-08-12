import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableBlocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableClass callableObj = new CallableClass("Hello Callble");
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// ExcutorService의 스레드들에게 callable작업 요청 반환 값은 Future객체에 저장됨
		// 스레드 풀의 스레드들이 작업이 아직 있다면 완료되지는 않을 수 있음
		Future<String> future = executor.submit(callableObj);
		
		try { 
			String result = future.get(); //future의 get은 작업이 완료될 때까지 Blocking됨
			//하지만 프로그래밍에 있어서 Block되는 것은 성능에 큰 영향을 끼침
			//따라서 callback 방법을 사용해 Block을 해결 
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
