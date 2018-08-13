import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//hashMap�� �����ϳ� synchronized�� ���� (Thread Safe)-> But, hashMap ���� ���� !!
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>(); 
		
		hashTable.put(1, "apple");
		hashTable.put(2, "banana");
		hashTable.put(3, "berry");
		hashTable.put(4, "melon");
		hashTable.put(100, "pine apple");
		
		System.out.println(hashTable.entrySet());
		
		Set<?> set = hashTable.entrySet();
		
		// key value ���� ����
		Iterator<?> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}
		
		// value ����
		Collection<String> collection = hashTable.values();
		Iterator<?> it2 = collection.iterator();
		while(it2.hasNext()) {
			Object value = it2.next();
			System.out.println(value.toString());
		}
		
		System.out.println(hashTable.get(4));
		// �ش� Ű�� �� ����
		hashTable.put(4, new String("water melon"));
		System.out.println(hashTable.get(4));
		
	}

}
