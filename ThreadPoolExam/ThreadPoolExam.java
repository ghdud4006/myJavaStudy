import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ExecutorService �������̽� ���� ��ü Executors �����޼��带 ���� �ִ� ������ ������ 2�� ������ Ǯ ����
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<10; i++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					// �����忡�� ��ų �۾� ����
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName(); //������ Ǯ�� �ִ� �ش� ������ �̸� ���
					System.out.println("[�� ������ ���� :"+poolSize+"]�۾� ������ �̸� : "+threadName);
					
					//�Ϻη� ���� �߻� 
					int value = Integer.parseInt("����");
				}
			};
			// ������ Ǯ���� �۾� ó�� ��û 
			executorService.execute(runnable); // return�� ����(runnable), ���� �߻��� ������ �� ����
			//executorService.submit(callable); // return�� ����(callable), ���� �߻��ص� ������ �� �������� ���� 
			
			// �ܼ� ��� �ð� �ֱ� ���� ���� ������ 0.01�� sleep
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
