package com.chen.dom4j.utils;

import java.io.File;
import java.net.MalformedURLException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtils {

	// 从文件读取XML，输入文件名，返回XML文档
	public Document read(String fileName) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(fileName));
		return document;
	}

	// 取得Root节点
	public Element getRootElement(Document doc) {
		return doc.getRootElement();
	}

}
