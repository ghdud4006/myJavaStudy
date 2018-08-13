import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//순서 보장 x , 중복허용 x 
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("b");
		hashSet.add("a");
		hashSet.add("a");
		hashSet.add("c");
		hashSet.add("d");
		hashSet.add("f");
		hashSet.add("e");
		System.out.println(hashSet);
		
		//입력 순서 보장 o , 중복허용 x 
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("b");
		linkedHashSet.add("a");
		linkedHashSet.add("a");
		linkedHashSet.add("c");
		linkedHashSet.add("d");
		linkedHashSet.add("f");
		linkedHashSet.add("e");
		System.out.println(linkedHashSet);
		
		
		//순서 오름차순 정렬 , 중복허용 x 
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("b");
		treeSet.add("a");
		treeSet.add("a");
		treeSet.add("c");
		treeSet.add("d");
		treeSet.add("f");
		treeSet.add("e");
		System.out.println(treeSet);
		
		
	}

}
