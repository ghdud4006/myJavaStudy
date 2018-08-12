
public class SingletonExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		
		if(singleton1 == singleton2) {
			System.out.println("same object");
		} else {
			System.out.println("different object");
		}

	}

}

class Singleton {
	private static Singleton one = null;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(one==null) {
			one = new Singleton();
		}
		return one;
	}
	
}
