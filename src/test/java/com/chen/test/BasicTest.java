package com.chen.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.chen.config.WebApplicationInitializer;
import com.chen.config.RootConfig;
import com.chen.config.WebConfig;
import com.chen.config.data.JpaHirConfig;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {WebConfig.class,RootConfig.class,WebApplicationInitializer.class,JpaHirConfig.class})  
@WebAppConfiguration
public class BasicTest    {

}
