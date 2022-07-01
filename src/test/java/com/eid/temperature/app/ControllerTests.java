package com.eid.temperature.app;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testBadParams() throws Exception {

		mvc.perform(get("/v2/stats/compute")
						.content("")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testBadNegativeReadingsAreInvalid() throws Exception {

		Gson gson = new Gson();
		Readings r = new Readings();
		r.setReadings(Arrays.asList(1L,-2L,3L));

		mvc.perform(get("/v2/stats/compute")
						.content(gson.toJson(r))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnprocessableEntity());
	}

	@Test
	public void testNullReadingsListIsValid() throws Exception {

		Gson gson = new Gson();
		Readings r = new Readings();
		r.setReadings(null);
		MvcResult res = mvc.perform(get("/v2/stats/compute")
						.content(gson.toJson(r))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		assertEquals(0L, Long.valueOf(res.getResponse().getContentAsString()));
	}

	@Test
	public void testValidReadings1() throws Exception {

		Gson gson = new Gson();
		Readings r = new Readings();
		r.setReadings(Arrays.asList(1L, 2L, 3L, 0L, 4L, 1L, 2L, 3L));
		MvcResult res = mvc.perform(get("/v2/stats/compute")
						.content(gson.toJson(r))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		assertEquals(4L, Long.valueOf(res.getResponse().getContentAsString()));
	}

	@Test
	public void testValidReadings2() throws Exception {

		Gson gson = new Gson();
		Readings r = new Readings();
		r.setReadings(Arrays.asList(10L, 15L, 18L, 1L, 8L));
		MvcResult res = mvc.perform(get("/v2/stats/compute")
						.content(gson.toJson(r))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		assertEquals(8L, Long.valueOf(res.getResponse().getContentAsString()));
	}
}
