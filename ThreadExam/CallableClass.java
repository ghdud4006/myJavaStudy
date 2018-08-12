import java.util.concurrent.Callable;

public class CallableClass implements Callable <String> {
	
	String str;
	
	public CallableClass(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return str;
	}

}
