package com.example.veriff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class VeriffService {

    private static final Logger log = LoggerFactory.getLogger(VeriffService.class);
    private final RestTemplate restTemplate;

    public VeriffService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> createSession(SessionRequest sessionRequest) {
        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-AUTH-CLIENT", "faa6e227-5b7d-4306-b9f5-879b5bc18f32");

        // Prepare request entity
        HttpEntity<SessionRequest> requestEntity = new HttpEntity<>(sessionRequest, headers);

        // External base URL for the Veriff API
        String baseUrl = "https://stationapi.veriff.com/v1/sessions";

        try {
            // Make the external POST request
            ResponseEntity<SessionResponse> response = restTemplate.postForEntity(baseUrl, requestEntity, SessionResponse.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body("Failed to create session");
            }
        } catch (HttpClientErrorException e) {
            // Log the error and return the error message
            log.error("Error creating session: {}", e.getResponseBodyAsString());
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        }
    }
}
