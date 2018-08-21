import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExam {

	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystems.getDefault();
		
		for(FileStore store : fileSystem.getFileStores()) { // ����̹� ������ ����  filestore ��ü���� ���� 
			System.out.println("����̹���:"+store.name());
			System.out.println("���Ͻý���:"+store.type());
			System.out.println("��ü ����:"+store.getTotalSpace()+" Byte");
			System.out.println("������� ����:"+(store.getTotalSpace()-store.getUnallocatedSpace())+" Byte");
			System.out.println("��� ������ ����:"+(store.getTotalSpace()-store.getUsableSpace())+" Byte");
		}
		
		System.out.println("���� ������: "+fileSystem.getSeparator()+"\n");
		
		for(Path path : fileSystem.getRootDirectories()) {
			System.out.println(path.toString());
		}
		
	}

}
