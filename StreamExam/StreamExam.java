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
		
		// 외부 반복자 사용
		Iterator<?> it = hmCollection.iterator();
		while(it.hasNext()) {
			Student student = (Student)it.next();
			System.out.println(
					"name:"+student.getName()
					+"/ score:"+student.getScore());
		}
		
		
		///////////// 이를 스트림 이용 , 내부 반복자 사용
		// steam을 이용해 내부 반복자를 사용함으로써 더 간단하게 코드완성, 병렬화가 더 쉽다.
		// stream의 forEach문과 람다식(stream의 메소드 함수적 인터페이스 매개타입을 가짐) 사용가능
		// but 함축적임으로 실수가 나오기 쉽다 
		// 내부 반복자가 잘못 돌 수 있따. 
		///////////////////////////////////////////
		
		// 순차 처리 스트림 
		Stream<Student> stream = hmCollection.stream();
		stream.forEach(student->{
			System.out.println(
					"/ name:"+student.getName()
					+"/ score:"+student.getScore());
			StreamExam.ThreadPrint();
		});
		
		
		// 병렬 처리 스트림
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
