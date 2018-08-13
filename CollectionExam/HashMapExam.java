import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;

public class HashMapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		synchronized(hashMap) {
			hashMap.put(1, "apple");
			hashMap.put(2, "banana");
			hashMap.put(3, "berry");
			hashMap.put(4, "melon");
			hashMap.put(100, "pine apple");
		}
		
		System.out.println(hashMap);
		System.out.println(hashMap.get(100));
		
		System.out.println(hashMap.containsKey(1));
		System.out.println(hashMap.containsValue("apple"));
		
		// key�� set�� ���
		Set<Integer> keys = hashMap.keySet();
		System.out.println(keys);
		
		// value�� collection�� ��� 
		Collection<String> values = hashMap.values();
		System.out.println(values);
		
		// map ��ȯ 
		Iterator<?> it = values.iterator();
		while(it.hasNext()) {
			Object value = it.next();
			System.out.println(value);
		}
		
		
	}

}
