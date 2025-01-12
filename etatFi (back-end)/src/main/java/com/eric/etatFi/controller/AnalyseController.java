package com.eric.etatFi.controller;

import com.eric.etatFi.service.AnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "analyse")
public class AnalyseController {
    private AnalyseService analyseService;

    @GetMapping(path = "marge-nette")
    public ResponseEntity<?> margeNette() {
        return ResponseEntity.ok(analyseService.margeNette());
    }
}
