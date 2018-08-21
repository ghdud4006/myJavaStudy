import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExam {

	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystems.getDefault();
		
		for(FileStore store : fileSystem.getFileStores()) { // 드라이버 정보를 가진  filestore 객체들을 리턴 
			System.out.println("드라이버명:"+store.name());
			System.out.println("파일시스템:"+store.type());
			System.out.println("전체 공간:"+store.getTotalSpace()+" Byte");
			System.out.println("사용중인 공간:"+(store.getTotalSpace()-store.getUnallocatedSpace())+" Byte");
			System.out.println("사용 가능한 공간:"+(store.getTotalSpace()-store.getUsableSpace())+" Byte");
		}
		
		System.out.println("파일 구분자: "+fileSystem.getSeparator()+"\n");
		
		for(Path path : fileSystem.getRootDirectories()) {
			System.out.println(path.toString());
		}
		
	}

}
