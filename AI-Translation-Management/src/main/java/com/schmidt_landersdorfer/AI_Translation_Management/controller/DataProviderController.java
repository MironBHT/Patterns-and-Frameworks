//package com.schmidt_landersdorfer.AI_Translation_Management.controller;
//
//import com.schmidt_landersdorfer.AI_Translation_Management.entity.DataProvider;
//import com.schmidt_landersdorfer.AI_Translation_Management.service.DataProviderService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/data-providers")
//public class DataProviderController {
//
//    private final DataProviderService dataProviderService;
//
//    public DataProviderController(DataProviderService dataProviderService) {
//        this.dataProviderService = dataProviderService;
//    }
//
//    // Get all DataProviders
//    @GetMapping
//    public ResponseEntity<List<DataProvider>> getAllDataProviders() {
//        List<DataProvider> dataProviders = dataProviderService.getAllDataProviders();
//        return ResponseEntity.ok(dataProviders);
//    }
//
//    // Get a single DataProvider by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<DataProvider>> getDataProviderById(@PathVariable Long id) {
//        Optional<DataProvider> dataProvider = dataProviderService.getDataProviderById(id);
//        return ResponseEntity.ok(dataProvider);
//    }
//
//    // Create a new DataProvider
//    @PostMapping
//    public ResponseEntity<DataProvider> createDataProvider(@RequestBody DataProvider dataProvider) {
//        DataProvider createdDataProvider = dataProviderService.createDataProvider(dataProvider);
//        return ResponseEntity.ok(createdDataProvider);
//    }
//
//    // Update an existing DataProvider
//    @PutMapping("/{id}")
//    public ResponseEntity<DataProvider> updateDataProvider(
//            @PathVariable Long id,
//            @RequestBody DataProvider updatedDataProvider) {
//        DataProvider dataProvider = dataProviderService.updateDataProvider(id, updatedDataProvider);
//        return ResponseEntity.ok(dataProvider);
//    }
//
//    // Delete a DataProvider by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteDataProvider(@PathVariable Long id) {
//        dataProviderService.deleteDataProvider(id);
//        return ResponseEntity.noContent().build();
//    }
//}



