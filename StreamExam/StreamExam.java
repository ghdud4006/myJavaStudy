import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Student> hm = new HashMap<String, Student>();
		
		hm.put("1", new Student("lee", 90));
		hm.put("2", new Student("park", 70));
		hm.put("3", new Student("kim", 80));
		
		Collection<Student> hmCollection = hm.values();
		
		// �ܺ� �ݺ��� ���
		Iterator<?> it = hmCollection.iterator();
		while(it.hasNext()) {
			Student student = (Student)it.next();
			System.out.println(
					"name:"+student.getName()
					+"/ score:"+student.getScore());
		}
		
		
		///////////// �̸� ��Ʈ�� �̿� , ���� �ݺ��� ���
		// steam�� �̿��� ���� �ݺ��ڸ� ��������ν� �� �����ϰ� �ڵ�ϼ�, ����ȭ�� �� ����.
		// stream�� forEach���� ���ٽ�(stream�� �޼ҵ� �Լ��� �������̽� �Ű�Ÿ���� ����) ��밡��
		// but ������������ �Ǽ��� ������ ���� 
		// ���� �ݺ��ڰ� �߸� �� �� �ֵ�. 
		///////////////////////////////////////////
		
		// ���� ó�� ��Ʈ�� 
		Stream<Student> stream = hmCollection.stream();
		stream.forEach(student->{
			System.out.println(
					"/ name:"+student.getName()
					+"/ score:"+student.getScore());
			StreamExam.ThreadPrint();
		});
		
		
		// ���� ó�� ��Ʈ��
		Stream<Student> parallelStream = hmCollection.parallelStream();
		parallelStream.forEach(student->{
			System.out.println(
					"/ name:"+student.getName()
					+"/ score:"+student.getScore());
			StreamExam.ThreadPrint();
		});
		
		
		
		
	}
	public static void ThreadPrint() {
		System.out.println("Thread:"+Thread.currentThread().getName());
	}
}

class Student {
	String name = null;
	int score = 0;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
