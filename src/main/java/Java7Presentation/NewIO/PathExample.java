package Java7Presentation.NewIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathExample {
	private static Path path = FileSystems.getDefault().getPath(
			Async.PATH);;

	public static void pathInfo() throws IOException {
		System.out.println("Number of Nodes: " + path.getNameCount());
		System.out.println("File Name: " + path.getFileName());
		System.out.println("File Root: " + path.getRoot());
		System.out.println("File Parent: " + path.getParent());
		System.out.println("File Owner: "
				+ Files.getOwner(path, LinkOption.NOFOLLOW_LINKS));
	}

	public static void main(String[] args) throws Exception {
		Files.copy(Paths.get("n:\\tmp\\acct2umbrellamapping.sql"), path,
				StandardCopyOption.REPLACE_EXISTING);

		pathInfo();

	//	Files.delete(path);
	//	Files.deleteIfExists(path);
	}

}