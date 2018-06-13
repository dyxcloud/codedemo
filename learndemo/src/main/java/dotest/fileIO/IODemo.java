package dotest.fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {

	@SuppressWarnings("resource")
	public static void writeAndRead() throws IOException {
		String path="E:\\Download\\iotest.txt";
		FileOutputStream os = new FileOutputStream(path);
		FileInputStream is = new FileInputStream(path);
		int s=128;
		os.write(s);
		os.close();
		int c;
		while((c=is.read())!=-1) {
			System.out.println(c);
			System.out.println(Integer.toBinaryString(c));
		}
		System.out.println(Integer.toBinaryString(s));
	}
	
	
	
	public static void main(String[] args) throws IOException {
		writeAndRead();
	}
}
