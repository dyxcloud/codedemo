package jdk.io.nio;

import org.junit.jupiter.api.Test;

import java.nio.CharBuffer;

public class BufferDemo {

	/**
	 * 显示buffer的position、limit、capacity和buffer中包含的字符，若字符为0，则替换为'.'
	 * @param buffer
	 */
	private void showBuffer(CharBuffer buffer) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buffer.limit(); i++) {
			char c = buffer.get(i);
			if (c == 0) {
				c = '.';
			}
			sb.append(c);
		}
		System.out.printf("position=%d, limit=%d, capacity=%d,content=%s\n", buffer.position(), buffer.limit(), buffer.capacity(), sb.toString());
	}

	@Test
	public void bufferPropertiesTet() {
		CharBuffer buffer = CharBuffer.allocate(10);
		// 初始状态
		showBuffer(buffer);
		// 存入三个字符后的状态
		buffer.put("abc");
		showBuffer(buffer);
		// flip后的状态
		buffer.flip();
		showBuffer(buffer);
		// 读取两个字符后的状态
		char c1 = buffer.get();
		char c2 = buffer.get();
		showBuffer(buffer);
		// clear后的状态
		buffer.clear();
		showBuffer(buffer);
	}

	@Test
	public void testMark() {
		CharBuffer buffer = CharBuffer.allocate(10);
		showBuffer(buffer);
		//设置mark位置为3
		buffer.position(3).mark().position(5);
		showBuffer(buffer);
		//reset后，position=mark
		buffer.reset();
		showBuffer(buffer);
	}

	@Test
	public void testCompact() {
		CharBuffer buffer = CharBuffer.allocate(10);
		buffer.put("abcde");
		buffer.flip();
		//先读取两个字符
		buffer.get();
		buffer.get();
		showBuffer(buffer);
		//压缩
		buffer.compact();
		showBuffer(buffer);
		//继续写入
		buffer.put("fghi");
		buffer.flip();
		showBuffer(buffer);
		//从头读取后续的字符
		char[] chars = new char[buffer.remaining()];
		buffer.get(chars);
		System.out.println(chars);
	}

	@Test
	public void testSlice() {
		CharBuffer buffer = CharBuffer.allocate(10);
		buffer.put("abcdefghij");
		buffer.position(5);
		CharBuffer slice = buffer.slice();
		showBuffer(buffer);
		showBuffer(slice);
	}
}
