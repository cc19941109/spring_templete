package com.chen.dom4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


/**
 * 
 * 参考: http://blog.csdn.net/dandanzmc/article/details/38730351
 * @author chencheng
 *
 */
public class Test2 {

	private static String filepath = "formula.xml";
	
	public static void main(String[] args) {
//		read();
		readStringXml();
//		readxml();
	}

	public static void readxml() {  
        SAXReader reader = new SAXReader(); // User.hbm.xml表示你要解析的xml文档  
        InputStream in = Thread.currentThread().getContextClassLoader()  
                .getResourceAsStream(filepath);  
        try {  
            Document doc = reader.read(in);  
            Element root = doc.getRootElement(); // 获取根节点  
            List<Element> list = new ArrayList<Element>();  
            list.add(root);  
            while (list != null) {  
                Element element = null;  
                Element ele = null;  
  
                Iterator ite = list.iterator();  
                if (ite.hasNext()) {  
                    ele = (Element) ite.next();  
                    ite.remove();  
                }  
                if (ele != null) {  
                    for (Iterator i = ele.elementIterator(); (i != null)  
                            && (i.hasNext());) {  
                        element = (Element) i.next();  
                        list.add(element);  
                        if (element != null) {  
                            System.out.println(element.getName() + " : "  
                                    + element.getPath() + " --"  
                                    + element.getText());  
                            for (Iterator iter = element.attributeIterator(); iter  
                                    .hasNext();) {  
                                Attribute item = (Attribute) iter.next();  
                                System.out.println(item.getName() + "为"  
                                        + item.getValue());  
                            }  
                        }  
                    }  
                }  
            }  
        } catch (DocumentException e) {  
  
            e.printStackTrace();  
        }  
    }  
	
	public static void readStringXml() {  
        // Document doc = null;  
        try {  
            // 读取并解析XML文档  
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来  
            SAXReader reader = new SAXReader(); // User.hbm.xml表示你要解析的xml文档  
            InputStream in = Thread.currentThread().getContextClassLoader()  
                    .getResourceAsStream(filepath);  
            Document doc = reader.read(in);  
            Element rootElt = doc.getRootElement(); // 获取根节点  
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称  
  
            for (int i = 0; i < rootElt.nodeCount(); i++) {  
                Node node = rootElt.node(i);  
                if (node instanceof Element) {  
                    Element elementTemp = (Element) node;  
                    System.out.println("二级节点：" + node.getName()); // 拿到第一个二级节点的名称do  
                    // 取得二级节点do的type和path属性的值  
                    for (Iterator iter = elementTemp.attributeIterator(); iter  
                            .hasNext();) {  
                        Attribute item = (Attribute) iter.next();  
                        System.out.println("二级节点do的：" + item.getName() + "为"  
                                + item.getValue()); // 拿到二级节点的path和type  
                    }  
                    // 获取二级节点的下面的子节点forward（三级节点）  
                    for (Iterator iterroot2 = elementTemp.elementIterator(); iterroot2  
                            .hasNext();) {  
                        Element root22 = (Element) iterroot2.next(); // 得到一个二级节点  
                        System.out.println("三级节点forward：" + root22.getName());  
                        System.out.println("三级节点forward的值：" + root22.getText()); // 获取forward的值  
                        List attrList = root22.attributes(); // 获取三级节点的属性  
                        // 遍历获取三级节点的属性  
                        for (Iterator iter = attrList.iterator(); iter  
                                .hasNext();) {  
                            Attribute item = (Attribute) iter.next();  
                            System.out.println("三级节点forward的属性："  
                                    + item.getName() + "为" + item.getValue());  
                        }  
                    }  
                }  
            }  
        } catch (DocumentException e) {  
            e.printStackTrace();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	
	
	public static void read() {  
        try {  
            // 读取并解析XML文档  
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来  
            SAXReader reader = new SAXReader(); // User.hbm.xml表示你要解析的xml文档  
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);  
            Document doc = reader.read(in);  
            // 获取根节点  
            Element rootElt = doc.getRootElement();
           System.out.println("rootElt:"+rootElt.getName());
            //获取do节点  
            Element doElement = rootElt.element("do");   
            //获取do节点下的属性  
            String path=doElement.attributeValue("path");  
            String type=doElement.attributeValue("type");  
            //获取forward节点  
            Element forwardElement =doElement.element("forward");  
            //获取forward节点中的属性和文本值  
            String name=forwardElement.attributeValue("name");  
            String value=forwardElement.getText();  
            System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称  
            System.out.println("do节点："+doElement.getName());  
            System.out.println("do节点的属性path和type分别为："+path+"、"+type);  
            System.out.println("forward节点："+forwardElement.getName());  
            System.out.println("forward节点属性name为："+name);  
            System.out.println("forward节点的文本值value为："+value);  
        } catch (DocumentException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

	
	
	
	
}