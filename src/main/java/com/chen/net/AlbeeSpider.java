package com.chen.net;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.JMException;

/**
 * Created by Albee on 2017/5/21.
 */
public class AlbeeSpider implements PageProcessor {
	// 设置编码 ，超时时间，重试次数，
	private Site site = Site.me().setRetryTimes(10).setSleepTime(5000).setTimeOut(5000)
			.addCookie("www.zhihu.com", "unlock_ticket",
					"QUJBTXRpWGJRd2dYQUFBQVlRSlZUZl83Q2xjZkJISHZkZm13R05Jck93eTNFU2IyUE53LWVnPT0=|"
							+ "1460335857|e1d68d4125f73b6280312c3eafa71da1b9fc7cab")
			// .addCookie("login",
			// "MWRiZWUxNmMzOTA5NDdmNTkwNGRmNWQyZWZhNDRmY2U=|1475371295|b9e9c165fc1d3c314afa2b66e3ff27c514bb4946")
			.addCookie("Domain", "zhihu.com")
			.addCookie("z_c0",
					"2|1:0|10:1503542388|4:z_c0|92:Mi4xeEtid0FRQUFBQUFBRU1KSWVaSkVEQ2NBQUFDRUFsVk5kTW5GV1FCMXViRmpHUzNrN3ZlVHpIVHFwNTdKbWlqeVZn|8da840969ccf7b764f4b08acb2a7a246b8f86ea0508f3b49fea3932295816b18")
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.89 Safari/537.36");
	// 话题精华页
	// https://www.zhihu.com/topic/19551388/top-answers
	private static final String URL_topAnswer = "https://www\\.zhihu\\.com/topic/\\d+/top-answers";
	private static final String URL_topAnswerPage = "https://www\\.zhihu\\.com/topic/\\d+/top-answers\\?page=\\d";
	// 话题索引页
	// https://www.zhihu.com/topic/19551388
	private static final String URL_topic = "^https://www\\.zhihu\\.com/topic/\\d+$";
	// 问题的索引
	// https://www.zhihu.com/question/20902967
	private static final String URL_question = "^https://www\\.zhihu\\.com/question/\\d+$";
	// https://www.baidu.com
	private static final String test = "https://www\\.baidu\\.com";
	// https://www.zhihu.com/question/19647535/answer/110944270
	private static final String URL_answer = "https://www\\.zhihu\\.com/question/\\d+/answer/\\d+";
	// https://www.zhihu.com/people/dan-wen-hui-10/answers
	private static final String URL_user = "https://www\\.zhihu\\.com/people/[\\s\\S]+/answers";

	private String offset = "0";

	@Override
	public void process(Page page) {

		if (page.getUrl().regex(URL_answer).match()) {
			List<String> urlList = page.getHtml().xpath("//div[@class=RichContent-inner]//img/@data-original").all();
			
			String questionTitle = page.getHtml().xpath("//h1[@class=QuestionHeader-title]/text()").toString();
			System.out.println("题目：" + questionTitle);
			urlList.stream().forEach(System.err::println);
			System.out.println(urlList.size());
			List<String> url = new ArrayList<String>();
			for (int i = 0; i < urlList.size(); i = i + 2) {
				url.add(urlList.get(i));
			}
//			String filePath = "/Users/common/download/";
			String filePath = "D:\\download\\";
			try {
				boolean isSuccess = downLoadPics(url, questionTitle, filePath);
				System.out.println("isSuccess: "+isSuccess);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) throws JMException {
		String answerUrl1 = "https://www.zhihu.com/question/27761934/answer/164790050";
		String answerUrl = "https://www.zhihu.com/question/33907128/answer/232969239";
		String questionUrl = "https://www.zhihu.com/question/29134042";
		Spider spider1 = Spider.create(new AlbeeSpider()).addUrl(answerUrl1).thread(1);
		SpiderMonitor.instance().register(spider1);
		spider1.start();

	}

	public static boolean downLoadPics(List<String> imgUrls, String title, String filePath) throws Exception {
		boolean isSuccess = true;

		// 文件路径+标题
		String dir = filePath + title;
		// 创建
		File fileDir = new File(dir);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}

		int i = 1;
		// 循环下载图片
		for (String imgUrl : imgUrls) {
			URL url = new URL(imgUrl);
			// 打开网络输入流
			DataInputStream dis = new DataInputStream(url.openStream());
			int x = (int) (Math.random() * 1000000);
			String newImageName = dir + "/" + x + "pic" + i + ".jpg";
			// 建立一个新的文件
			FileOutputStream fos = new FileOutputStream(new File(newImageName));
			byte[] buffer = new byte[1024];
			int length;
			System.out.println("正在下载......第 " + i + "张图片......请稍后");
			// 开始填充数据
			while ((length = dis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			dis.close();
			fos.close();
			System.out.println("第 " + i + "张图片下载完毕......");
			i++;
		}
		return isSuccess;
	}

}
