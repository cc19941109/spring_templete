package com.chen.java8.chapter1;

import java.io.File;
import java.io.FileFilter;

public class Java8Introduce {

	public static void main(String[] args) {
		Java8Introduce introduce = new Java8Introduce();
		introduce.afterJava8();

			
	}

	public void afterJava8(){
		//FileFilter is a FunctionalInterface;
		File[] files = new File(".").listFiles(File::isHidden);
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	
	public void beforeJava8() {
		File[] files = new File(".").listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		});

		for (File file : files) {
			System.out.println(file.getName());
		}
	}

}
