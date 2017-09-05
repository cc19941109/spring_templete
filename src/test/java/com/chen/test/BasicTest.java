package com.chen.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.chen.config.DispacherConfig;
import com.chen.config.data.JpaHirConfig;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {DispacherConfig.class,JpaHirConfig.class})  
//@WebAppConfiguration
public class BasicTest {

}
