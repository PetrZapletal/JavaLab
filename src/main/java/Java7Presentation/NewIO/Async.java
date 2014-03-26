package Java7Presentation.NewIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.Future;

public class Async {

    public static final String PATH = "n:\\tmp\\acct2umbrellamapping.sql";

	public static void main(String[] args) throws Exception {

		FileSystem fs = FileSystems.getDefault();
		Path path = fs.getPath(PATH);
		AsynchronousFileChannel ch = AsynchronousFileChannel.open(path);
		ByteBuffer buf = ByteBuffer.allocate(2048);
		Future<Integer> res = ch.read(buf, 0);

		while (!res.isDone()) {
			Thread.sleep(500);
			System.out.println("Doing something else ....");
			Thread.sleep(500);
			System.out.println("Doing something else ....");
			Thread.sleep(500);
		}

		System.out.println("Bytes read: " + res.get());
		ch.close();
	}
}
