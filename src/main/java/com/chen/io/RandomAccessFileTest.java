package com.chen.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {

		String separator = File.separator;
		String fileName = separator + "Users" + separator + "chencheng" + separator + "git" + separator + "learn"
				+ separator + "1.txt";

		RandomAccessFileTest raft = new RandomAccessFileTest();
		// raft.randomAccess(fileName);
		// raft.outputTest(fileName);
		raft.addTxtTest(fileName);
		raft.readFileByInputStream(fileName);
		System.out.println("test success...");
	}

	public void readFileByInputStream(String fileName) throws IOException{
		 File f=new File(fileName);
	        InputStream in=new FileInputStream(f);
	        byte[] b=new byte[1024];
	        in.read(b);
	        in.close();
	        System.err.println(new String(b));
	}
	
	public void addTxtTest(String fileName) throws IOException {

		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f, true);
		String str = "\r\nRollen 你好\r\n";
		// String str="\r\nRollen"; 可以换行
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
	}

	public void outputTest(String fileName) throws IOException {
		/**
		 * 字节流 向文件中写入字符串
		 */
		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f);
		String str = "你好";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
	}

	public void randomAccess(String fileName) throws IOException {
		// 输出是乱码
		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
		}
		RandomAccessFile demo = new RandomAccessFile(f, "rw");
		demo.writeBytes("asdsad");
		demo.writeInt(12);
		demo.writeBoolean(true);
		demo.writeChar('A');
		demo.writeFloat(1.21f);
		demo.writeDouble(12.123);
		demo.close();
	}
}
