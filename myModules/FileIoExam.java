import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIoExam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//�⺻ ���� write
		PrintWriter wr = new PrintWriter("d:/out.txt");
		wr.println("hello file io");
		wr.close();
		
		// ���� �߰� write
		PrintWriter wa = new PrintWriter(new FileWriter("d:/out.txt", true));
		wa.println("hello file io");
		wa.close();
		
		
		// ���� read
		BufferedReader br = new BufferedReader(new FileReader("d:/out.txt"));
		while(true) {
			String line = br.readLine();
			if(line==null) break;
			System.out.println(line);
		}
		br.close();
		
	}

}
