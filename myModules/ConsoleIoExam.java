import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleIoExam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// sol 1
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = keyboard.readLine()) != null) {
			System.out.println("input success:"+line);
			line = null;
		}
		
		
		// sol 2 scanner
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.next());
		
	}

}
