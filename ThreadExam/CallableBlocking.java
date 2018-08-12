import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableBlocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableClass callableObj = new CallableClass("Hello Callble");
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// ExcutorService�� ������鿡�� callable�۾� ��û ��ȯ ���� Future��ü�� �����
		// ������ Ǯ�� ��������� �۾��� ���� �ִٸ� �Ϸ������ ���� �� ����
		Future<String> future = executor.submit(callableObj);
		
		try { 
			String result = future.get(); //future�� get�� �۾��� �Ϸ�� ������ Blocking��
			//������ ���α׷��ֿ� �־ Block�Ǵ� ���� ���ɿ� ū ������ ��ħ
			//���� callback ����� ����� Block�� �ذ� 
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
