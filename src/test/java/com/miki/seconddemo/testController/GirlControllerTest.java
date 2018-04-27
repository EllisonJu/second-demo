package com.miki.seconddemo.testController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void girlList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/gril/girlList"))
			.andExpect(MockMvcResultMatchers.status().isOk())//返回的是状态码
//			.andExpect(MockMvcResultMatchers.content().string("abbnn"))//对返回的内容进行判断
			;
			
	}
}
