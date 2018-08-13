import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NonBlockingMapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///////////////////////////////////////////
		/// synchronized의 동기화 Block은 동시성을 해침 -> SW 성능 낮아짐
		/// 따라서 concurrent(동시적)접근이 가능한 Collection library가 생김
		///////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////// ConcurrentHashMap //////// 부분 lock (Map을 Concurrent레벨의 16구역으로 나누어 해당역역별로 Lock)
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		
		chm.put("key", "value");
		
		chm.putIfAbsent("key2", "value2");
		
		///////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////// ConcurrentLinkedQueue //////// Lock-free Alg 사용한 Queue (동시접근 적어도 하나는 성공)
		//// Lock을 걸지 않고 Old값이 변했다면 건드리지 않음 // 알고있는 old값이 변하지 않았다면 건드림(성공)
		Queue<String> q = new ConcurrentLinkedQueue<String>();
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		q.add("e");
		Iterator<String> it = q.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.print(value);
		}
		
		
	}

}
