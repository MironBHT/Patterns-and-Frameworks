package com.schmidt_landersdorfer.AI_Translation_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Collections;
import java.util.Map;

@Component
public class HuggingFaceClient {

    private final RestTemplate restTemplate;
    private final HuggingFaceConfig config;

    @Autowired
    public HuggingFaceClient(RestTemplate restTemplate, HuggingFaceConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    public String translateText(String text, String targetLanguage) {
        String url = config.getApiUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + config.getApiKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = Map.of(
                "inputs", text,
                "target_language", targetLanguage
        );

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            } else {
                return "Error: Unexpected response from Hugging Face API";
            }
        } catch (Exception e) {
            return "Error during translation: " + e.getMessage();
        }
    }

}
