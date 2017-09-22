package com.chen.net.annotation;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractBy.Source;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

//@TargetUrl为目标页面url
//@HelpUrl 为要获取目标页面url,所需要的url
@TargetUrl("https://github.com/\\w+/\\w+")
@HelpUrl("https://github.com/\\w+")
public class GithubRepo {
	
	//@ExtractBy是一个用于抽取元素的注解
	@ExtractBy(value = "//h1[@class='entry-title public']/strong/a/text()", notNull = true,source = Source.RawHtml)
    private String name;

    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String author;

    @ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://github.com/code4craft").thread(5).run();
    }
	
	
}