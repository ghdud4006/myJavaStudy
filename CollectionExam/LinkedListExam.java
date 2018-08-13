import java.util.LinkedList;

public class LinkedListExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> linkedList = new LinkedList<String>();
		
		
		// 빈번한 객체의 삽입/이동/제거가 이루어지면 ArrayList보다 좋은 성능을 가진다. 
		synchronized(linkedList) {
			linkedList.add("hello 0");
			linkedList.add("hello 1");
			linkedList.add("hello 2");
			linkedList.add("hello 3");
			linkedList.add("hello 4");
			linkedList.add("hello 5");
			linkedList.add("hello 6");
			linkedList.add("hello 7");
			linkedList.add("hello 8");
			linkedList.add("hello 9");
		}
		
		System.out.println(linkedList.size());
		System.out.println(linkedList);
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());
		linkedList.removeLast();
		System.out.println(linkedList);
		
		// get method
		Object obj = linkedList.get(0);
		System.out.println(obj);
		
		// set method
		linkedList.set(0, "bye 0");
		System.out.println(linkedList);
		
		
	}

}
