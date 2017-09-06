package com.chen.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.chen.controller.IndexController;
import com.chen.test.BasicTest;

public class IndexControllerTest extends BasicTest{

	@Test
	public void testI() throws Exception {
		IndexController indexController = new IndexController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/t")).andExpect(view().name("test"));
		
	}
	
	
}
