package com.chen.dom4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		Document readXmlDocument = readXmlDocument("/user.xml");

	}

	public static Document readXmlDocument(String filePath) {

		InputStream in = null;
		Document doc = null;

		// 解析xml文档内容
		try {
			SAXReader reader = new SAXReader();
			// in =
			// XMLUtil.class.getClassLoader().getResourceAsStream(filePath);//
			// 获取到xml文件
			in = new FileInputStream(new File(filePath));
			doc = reader.read(in);
			in.close();
		} catch (Exception e) {
			System.out.println("XMLUtil.readXml error: " + e);
			// logger.error("XMLUtil.readXml error: " + e);
			return null;
		} finally {
			// close(null, null, in);
		}
		return doc;
	}

	public static List<Element> readXml(String filePath) {

		InputStream in = null;
		List<Element> elementList = null;
		// 解析xml文档内容
		try {
			SAXReader reader = new SAXReader();
			// in =
			// XMLUtil.class.getClassLoader().getResourceAsStream(filePath);//
			// 获取到xml文件
			in = new FileInputStream(new File(filePath));
			Document doc = reader.read(in);

			Element root = doc.getRootElement();
			elementList = root.elements();
			System.out.println("XMLUtil.readXml root name:" + root.getName());
			// logger.debug("XMLUtil.readXml root name:" + root.getName());

			in.close();
			
		} catch (Exception e) {
			System.out.println("XMLUtil.readXml error: " + e);
			// logger.error("XMLUtil.readXml error: "+ e);
			return null;
			
		} finally {
			// close(null,null,in);
		}
		return elementList;
	}

}
