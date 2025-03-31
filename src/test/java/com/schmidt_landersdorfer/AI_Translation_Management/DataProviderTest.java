package com.schmidt_landersdorfer.AI_Translation_Management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
import com.schmidt_landersdorfer.AI_Translation_Management.repository.DataProviderRepository;
import com.schmidt_landersdorfer.AI_Translation_Management.service.DataProviderService;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
class DataProviderServiceTest {

    @Mock
    private DataProviderRepository dataProviderRepository;

    @InjectMocks
    private DataProviderService dataProviderService;

    private DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider(1L, "Provider1", "http://example.com", "Description", null, null);
    }

    @Test
    void getAllDataProviders() {
        when(dataProviderRepository.findAll()).thenReturn(List.of(dataProvider));
        assertEquals(1, dataProviderService.getAllDataProviders().size());
    }

    @Test
    void getDataProviderById() {
        when(dataProviderRepository.findById(1L)).thenReturn(Optional.of(dataProvider));
        assertTrue(dataProviderService.getDataProviderById(1L).isPresent());
    }

    @Test
    void createDataProvider() {
        when(dataProviderRepository.save(any(DataProvider.class))).thenReturn(dataProvider);
        DataProvider createdProvider = dataProviderService.createDataProvider(dataProvider);
        assertEquals("Provider1", createdProvider.getProviderName());
    }

    @Test
    void updateDataProvider() {
        when(dataProviderRepository.existsById(1L)).thenReturn(true);
        when(dataProviderRepository.save(any(DataProvider.class))).thenReturn(dataProvider);
        DataProvider updatedProvider = dataProviderService.updateDataProvider(1L, dataProvider);
        assertEquals("Provider1", updatedProvider.getProviderName());
    }

    @Test
    void updateDataProvider_notFound() {
        when(dataProviderRepository.existsById(1L)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> dataProviderService.updateDataProvider(1L, dataProvider));
    }

    @Test
    void deleteDataProvider() {
        when(dataProviderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(dataProviderRepository).deleteById(1L);
        dataProviderService.deleteDataProvider(1L);
        verify(dataProviderRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteDataProvider_notFound() {
        when(dataProviderRepository.existsById(1L)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> dataProviderService.deleteDataProvider(1L));
    }
}
