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
		
		// ���� ���� ����
		Comparator<Integer> comparator = Collections.reverseOrder();
		
		// �÷��� ��Ʈ
		Collections.sort(linkedList, comparator);
		Iterator<Integer> it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		/////////// ����Ʈ ����
		Collections.shuffle(linkedList);
		it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		
		//�ݴ�� ����
		Collections.reverse(linkedList);
		it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		LinkedList<Integer> copiedList = new LinkedList<Integer>();
		
		//����Ʈ ��� �߰�
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
		// �ִ밪 �ּҰ� ���� 
		System.out.println(Collections.min(linkedList));
		System.out.println(Collections.max(linkedList));
		
		
		
	}

}
