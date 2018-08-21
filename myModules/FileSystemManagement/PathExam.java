import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathExam {

	public static void main(String[] args) {
		// Path ��ü ���� 
		Path path = Paths.get("./src/PathExam.java");
		
		// �⺻ �������̽�
		System.out.println("���� ��:"+path.getFileName());
		System.out.println("�θ� ���丮 ��:"+path.getParent().getFileName());
		System.out.println("��ø ��� ��:"+path.getNameCount()+"\n");
		
		// ���� ������ ��� ����ŭ ��� file/dir name ��� 
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
		
		// sol2)iterator�� ���� ���
		System.out.println();
		Iterator<Path> it = path.iterator();
		while(it.hasNext()) {
			Path temp = it.next();
			System.out.println(temp.getFileName());
		}
		
		
	}

}
