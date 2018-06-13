package util;

import java.io.File;

public class RenameUtil {

	public static void rename() {
		File temp = new File("E:\\Download\\temp\\cache");
		temp.mkdirs();
		File file = new File("E:\\Download\\temp");
		File[] files = file.listFiles();
		for (File file2 : files) {
			String name = file2.getName();
			File[] listFiles = file2.listFiles();
			listFiles[0].renameTo(new File(temp, name));
		}
	}

	public static void main(String[] args) {
		rename();
	}
}
