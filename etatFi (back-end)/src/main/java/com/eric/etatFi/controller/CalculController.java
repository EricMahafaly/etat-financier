package com.eric.etatFi.controller;

import com.eric.etatFi.service.CalculService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "calcul")
public class CalculController {
    private CalculService calculService;.

    @GetMapping(path = "marge-nette")
    public ResponseEntity<?> margeNette() {
        calculService.margeNette();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
