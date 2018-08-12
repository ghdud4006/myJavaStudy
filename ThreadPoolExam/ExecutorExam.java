import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Executor executor = Executors.newFixedThreadPool(5);
		
		RunnableClass runnableClass = new RunnableClass("hello");
		executor.execute(runnableClass);
		
	}

}

class RunnableClass implements Runnable {
	
	String outMsg;

	public RunnableClass(String outMsg) { //constructor
		this.outMsg = outMsg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Runnable class : "+outMsg);
	}
	
}
