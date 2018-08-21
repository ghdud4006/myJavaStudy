import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathExam {

	public static void main(String[] args) {
		// Path 객체 만듬 
		Path path = Paths.get("./src/PathExam.java");
		
		// 기본 인터페이스
		System.out.println("파일 명:"+path.getFileName());
		System.out.println("부모 디렉토리 명:"+path.getParent().getFileName());
		System.out.println("중첩 경로 수:"+path.getNameCount()+"\n");
		
		// 여태 까지의 경로 수만큼 경로 file/dir name 출력 
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
		
		// sol2)iterator를 쓰는 방법
		System.out.println();
		Iterator<Path> it = path.iterator();
		while(it.hasNext()) {
			Path temp = it.next();
			System.out.println(temp.getFileName());
		}
		
		
	}

}
