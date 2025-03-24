package com.schmidt_landersdorfer.AI_Translation_Management;

import com.schmidt_landersdorfer.AI_Translation_Management.controller.DataProviderController;
import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
import com.schmidt_landersdorfer.AI_Translation_Management.service.DataProviderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class DataProviderControllerTest {

	@Mock
	private DataProviderService dataProviderService;

	@InjectMocks
	private DataProviderController dataProviderController;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(dataProviderController).build();
	}

	@Test
	void getAllDataProviders() throws Exception {
		mockMvc.perform(get("/api/data-providers"))
				.andExpect(status().isOk());
	}

	@Test
	void getDataProviderById_found() throws Exception {
		DataProvider dataProvider = new DataProvider(1L, "Provider1", "http://example.com", "Description", null, null);
		when(dataProviderService.getDataProviderById(1L)).thenReturn(Optional.of(dataProvider));

		mockMvc.perform(get("/api/data-providers/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.providerName").value("Provider1"));
	}

	@Test
	void getDataProviderById_notFound() throws Exception {
		when(dataProviderService.getDataProviderById(1L)).thenReturn(Optional.empty());

		mockMvc.perform(get("/api/data-providers/1"))
				.andExpect(status().isNotFound());
	}

	@Test
	void createDataProvider() throws Exception {
		DataProvider dataProvider = new DataProvider(1L, "Provider1", "http://example.com", "Description", null, null);
		when(dataProviderService.createDataProvider(any(DataProvider.class))).thenReturn(dataProvider);

		mockMvc.perform(post("/api/data-providers")
						.contentType("application/json")
						.content("{\"providerName\":\"Provider1\", \"url\":\"http://example.com\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.providerName").value("Provider1"));
	}

	@Test
	void updateDataProvider() throws Exception {
		DataProvider dataProvider = new DataProvider(1L, "Updated Provider", "http://example.com", "Updated Description", null, null);
		when(dataProviderService.updateDataProvider(eq(1L), any(DataProvider.class))).thenReturn(dataProvider);

		mockMvc.perform(put("/api/data-providers/1")
						.contentType("application/json")
						.content("{\"providerName\":\"Updated Provider\", \"url\":\"http://example.com\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.providerName").value("Updated Provider"));
	}

	@Test
	void deleteDataProvider() throws Exception {
		doNothing().when(dataProviderService).deleteDataProvider(1L);

		mockMvc.perform(delete("/api/data-providers/1"))
				.andExpect(status().isNoContent());
	}
}
