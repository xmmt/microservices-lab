package com.example.myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private VisitsRepository visitsRepository;

	@BeforeEach
	public void setUp() throws Exception {
		visitsRepository.deleteAll();
	}

	@Test
	public void indexControllerShouldReturnHtmlPage() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to Spring")));
	}

	@Test
	public void apiControllerShouldReturnVisits() throws Exception {
		mockMvc.perform(get("/"));

		mockMvc.perform(get("/api/visits"))
				.andExpect(jsonPath("$.*.description", iterableWithSize(1)));
	}

}
