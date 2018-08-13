import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(new Integer(-1));
		linkedList.add(new Integer(20));
		linkedList.add(new Integer(-20));
		linkedList.add(new Integer(1));
		
		// 역순 비교자 생성
		Comparator<Integer> comparator = Collections.reverseOrder();
		
		// 컬렉션 소트
		Collections.sort(linkedList, comparator);
		Iterator<Integer> it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		/////////// 리스트 셔플
		Collections.shuffle(linkedList);
		it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		
		//반대로 변경
		Collections.reverse(linkedList);
		it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		LinkedList<Integer> copiedList = new LinkedList<Integer>();
		
		//리스트 모두 추가
		copiedList.addAll(linkedList);
		it = copiedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		System.out.println(copiedList.hashCode());
		System.out.println(linkedList.hashCode());
		System.out.println(linkedList.equals(copiedList));
		copiedList.add(300);
		// 최대값 최소값 도출 
		System.out.println(Collections.min(linkedList));
		System.out.println(Collections.max(linkedList));
		
		
		
	}

}
