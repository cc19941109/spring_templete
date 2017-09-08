package com.chen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import org.yaml.snakeyaml.Yaml;

public class YmlTest {
	public static void main(String[] args) throws FileNotFoundException {

		Yaml yaml = new Yaml();
		File f = new YmlTest().getFile("test.yml"); // 读入文件

		Object result = yaml.load(new FileInputStream(f));
		System.out.println(result.getClass());
		System.out.println(result);

	}

	private File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(fileName);

		System.out.println(url.getFile());
		File file = new File(url.getFile());
		System.out.println(file.exists());
		return file;
	}
}
