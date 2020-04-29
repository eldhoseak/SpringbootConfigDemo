package com.config.demo;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest(ConfigController.class)
@TestPropertySource(locations = "/application-test.properties")
public class ConfigControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testExample() throws Exception {
		MvcResult result = this.mvc.perform(get("/configProperties").accept(MediaType.TEXT_PLAIN))
		.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("Demo Application - test"));
	}
}
