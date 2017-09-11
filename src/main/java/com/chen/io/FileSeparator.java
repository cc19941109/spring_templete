package com.chen.io;

import java.io.File;

public class FileSeparator {
	public static void main(String[] args) {
		String separator = File.separator;
		String path_separator = File.pathSeparator;

		String path = "D:" + separator + "chen" + separator + "file" + separator + "testIO" + separator;
		System.out.println(path);
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);

		File file = new File(path);
		System.out.println(file.exists());
		
		File f=new File(path+"test");
        f.mkdir();
        
        String[] str=new File(".\\src\\main\\java").list();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        
        System.err.println(new File(".").isDirectory());
        System.out.println("---------------------------");
        print(new File(".//src//main//java//com//chen//config//"));
	}
	
	
	public static void print(File f){
        if(f!=null){
            if(f.isDirectory()){
                File[] fileArray=f.listFiles();
                if(fileArray!=null){
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        print(fileArray[i]);
                    }
                }
            }
            else{
                System.err.println(f);
            }
        }
    }
	
	
}


