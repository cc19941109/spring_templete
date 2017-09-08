package com.chen.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class YmlTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		Representer representer =new Representer();
//		representer.addClassTag(WaterMelon.class, new Tag(clazz))
		
	}

	public void testDump() throws FileNotFoundException {

		Yaml yaml = new Yaml();
		WaterMelon waterMelon = new WaterMelon("big melon", 1, 3.2);
		System.out.println(yaml.dump(waterMelon));
		File f = new File("test.yml");
		Map result = (Map) yaml.load(new FileInputStream(f));
		System.out.println(result);
	}

	public void test() throws FileNotFoundException {
		Yaml yaml = new Yaml();

		File f = new YmlTest().getFile("test.yml"); // 读入文件
		Iterable result = yaml.loadAll(new FileInputStream(f));
		System.out.println(result.getClass().getName());
		Iterator iterator = result.iterator();

		while (iterator.hasNext()) {
			// System.out.println(iterator.next().getClass());
			System.out.println(iterator.next());
		}
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
