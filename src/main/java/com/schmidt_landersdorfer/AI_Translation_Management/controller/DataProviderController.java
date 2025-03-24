package com.schmidt_landersdorfer.AI_Translation_Management.controller;

import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
import com.schmidt_landersdorfer.AI_Translation_Management.service.DataProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data-providers")
public class DataProviderController {

    private final DataProviderService dataProviderService;

    public DataProviderController(DataProviderService dataProviderService) {
        this.dataProviderService = dataProviderService;
    }


    @GetMapping
    public ResponseEntity<List<DataProvider>> getAllDataProviders() {
        List<DataProvider> dataProviders = dataProviderService.getAllDataProviders();
        return ResponseEntity.ok(dataProviders);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DataProvider> getDataProviderById(@PathVariable Long id) {
        return dataProviderService.getDataProviderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<DataProvider> createDataProvider(@RequestBody DataProvider dataProvider) {
        DataProvider createdDataProvider = dataProviderService.createDataProvider(dataProvider);
        return ResponseEntity.ok(createdDataProvider);
    }



    @PutMapping("/{id}")
    public ResponseEntity<DataProvider> updateDataProvider(
            @PathVariable Long id,
            @RequestBody DataProvider updatedDataProvider) {
        DataProvider dataProvider = dataProviderService.updateDataProvider(id, updatedDataProvider);
        return ResponseEntity.ok(dataProvider);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataProvider(@PathVariable Long id) {
        dataProviderService.deleteDataProvider(id);
        return ResponseEntity.noContent().build();
    }
}



