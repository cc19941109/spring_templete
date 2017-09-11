package com.chen.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		
		//输出是乱码
		String separator = File.separator;
		String fileName=separator+"Users"+separator+"chencheng"+separator+"git"+separator+"learn"+separator+"1.txt";
		
        File f=new File(fileName);
        if (!f.exists()) {
			f.createNewFile();
		}
        RandomAccessFile demo=new RandomAccessFile(f,"rw");
        demo.writeBytes("asdsad");
        demo.writeInt(12);
        demo.writeBoolean(true);
        demo.writeChar('A');
        demo.writeFloat(1.21f);
        demo.writeDouble(12.123);
        demo.close();  
	}
}
