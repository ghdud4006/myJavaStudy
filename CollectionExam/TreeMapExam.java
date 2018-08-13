import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 빠른 검색을 가능하게 함
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		
		synchronized(treeMap) { 
			treeMap.put("lee", 100);
			treeMap.put("song", 200);
			treeMap.put("kim", 500);
			treeMap.put("huh", 400);
			treeMap.put("kim", 300);
		}
		
		Set<?> set = treeMap.entrySet();
		Iterator<?> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			System.out.print(me.getKey()+":");
			System.out.println(me.getValue());
		}
		
		int bonus = 1000;
		treeMap.put("lee", new Integer(bonus+treeMap.get("lee").intValue()));
		System.out.println(treeMap.get("lee"));
		
	}

}
