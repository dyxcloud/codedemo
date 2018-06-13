package dotest.fileIO.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

import org.junit.Test;

public class FileChannelDemo {

	/**
	 * Files类
	 * 
	 * @author DongYunxiang
	 * @date 2017年12月22日
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String[] readFileAllLines(Path path) throws IOException {
		List<String> lineList = java.nio.file.Files.readAllLines(path, StandardCharsets.UTF_8);
		return lineList.toArray(new String[0]);
	}

	/**
	 * FileChannel类
	 * 
	 * @author DongYunxiang
	 * @date 2017年12月22日
	 * @param src
	 * @param desc
	 */
	public static void copyFile(String src, String desc) {
//		try (FileChannel input = new FileInputStream(src).getChannel();
//				FileChannel output = new FileOutputStream(desc).getChannel();) {
//			output.transferFrom(input, 0, input.size());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	

}
