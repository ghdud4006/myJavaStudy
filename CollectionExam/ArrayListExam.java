import java.util.ArrayList;
import java.util.Collection;

public class ArrayListExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<String>();
		
		
		synchronized(arrayList) { // 스레드 동기화
			arrayList.add("hello");
			arrayList.add("hi");
			arrayList.add("good");
			arrayList.add("apple");
			arrayList.add("bye");
		}
		
		System.out.println(arrayList);
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.size());
		
		arrayList.remove(1);
		
		System.out.println(arrayList);
		System.out.println(arrayList.get(1));
		System.out.println(arrayList.size());
		
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		
		//어레이리스트 -> 어레이로 변경 
		//type문제로 최상위 객체인 Object로 반환됌
		Object strArr[] = arrayList.toArray();
		arrayList.clear();
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
	}

}
