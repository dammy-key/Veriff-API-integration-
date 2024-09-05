package com.example.veriff;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sessions")
public class VeriffController {

    private final VeriffService veriffService;

    public VeriffController(VeriffService veriffService) {
        this.veriffService = veriffService;
    }

    @PostMapping
    public ResponseEntity<?> createSession(@RequestBody SessionRequest sessionRequest) {
        return veriffService.createSession(sessionRequest);
    }
}
