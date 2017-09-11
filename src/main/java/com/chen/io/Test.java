package com.chen.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) throws IOException {
		String path = "D:\\chen\\file\\testIO\\";
		File file1 = new File(path + "a.txt");

		if (!file1.exists()) {
			file1.createNewFile();
		}
		
		 FileInputStream fis = null;
			try {
				fis = new FileInputStream(file1);
				// 设置一个，每次 装载信息的容器
				byte[] buf = new byte[1024];
				// 定义一个StringBuffer用来存放字符串
				StringBuffer sb = new StringBuffer();
				// 开始读取数据
				int len = 0;// 每次读取到的数据的长度
				while ((len = fis.read(buf)) != -1) {// len值为-1时，表示没有数据了
					// append方法往sb对象里面添加数据
					sb.append(new String(buf, 0, len, "GBK"));
					System.err.println(sb.toString());
				}
				// 输出字符串
				System.out.println(sb.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}

class DirFilter implements FilenameFilter {

	 private Pattern pattern;
	    public DirFilter(String regex) {
	        pattern= Pattern.compile(regex);
	    }
	    @Override
	    public boolean accept(File dir, String name) {
	        return pattern.matcher(name).matches();
	    }
	    

}