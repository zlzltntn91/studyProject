package toby.vol1.real;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class FileReaderTest {

	MyFileReader reader;

	@Before
	public void init() {
		this.reader = new MyFileReader(getClass().getResource("num.txt").getPath());
	}

	@Test
	public void getFileContent() throws IOException {
		int [] line = reader.getFileContent();
		Arrays.stream(line).forEach(System.out::println);
	}

	@Test
	public void getPath() {
		log.info(reader.getPath());
	}

	static final class MyFileReader {

		private final String path;

		public MyFileReader(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}

		public int[] getFileContent() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(getPath()));
			return br.lines().mapToInt(v -> Integer.parseInt(v)).toArray();
		}
	}
}
