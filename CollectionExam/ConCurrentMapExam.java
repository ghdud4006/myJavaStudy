import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NonBlockingMapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///////////////////////////////////////////
		/// synchronized�� ����ȭ Block�� ���ü��� ��ħ -> SW ���� ������
		/// ���� concurrent(������)������ ������ Collection library�� ����
		///////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////// ConcurrentHashMap //////// �κ� lock (Map�� Concurrent������ 16�������� ������ �ش翪������ Lock)
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		
		chm.put("key", "value");
		
		chm.putIfAbsent("key2", "value2");
		
		///////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////// ConcurrentLinkedQueue //////// Lock-free Alg ����� Queue (�������� ��� �ϳ��� ����)
		//// Lock�� ���� �ʰ� Old���� ���ߴٸ� �ǵ帮�� ���� // �˰��ִ� old���� ������ �ʾҴٸ� �ǵ帲(����)
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
