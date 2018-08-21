import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExam {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Path path1 = Paths.get("D:/0my/testDir/dir");
		Path path2 = Paths.get("D:/0my/testDir/a.txt");
		
		if(Files.notExists(path1)) {
			Files.createDirectories(path1);
		}
		
		if(Files.notExists(path2)) {
			Files.createFile(path2);
		}
		
		Path path3 = Paths.get("D:/0my/testDir");
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
		
		for(Path path : directoryStream) {
			if(Files.isDirectory(path)) {
				System.out.println("디렉토리:"+path.getFileName());
			} else {
				System.out.print("파일:"+path.getFileName());
				System.out.println("(크기:"+Files.size(path)+")");
			}
		}
		
		
		
	}

}
