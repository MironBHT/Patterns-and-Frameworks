//package com.schmidt_landersdorfer.AI_Translation_Management;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//@Service
//public class HuggingfaceService {
//
//    @Value("${huggingface.api.url}")
//    private String apiUrl;
//
//    @Value("${huggingface.api.key}")
//    private String apiKey;
//
//    private final RestTemplate restTemplate;
//
//    public HuggingfaceService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String translateText(String text) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
//
//        String payload = "{\"inputs\": \"" + text + "\"}";
//
//        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                apiUrl, HttpMethod.POST, entity, String.class);
//
//        // Hier kannst du die Antwort nach Bedarf verarbeiten
//        return response.getBody();
//    }
//}
//
//
//
//
