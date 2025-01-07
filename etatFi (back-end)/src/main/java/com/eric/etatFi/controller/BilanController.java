package com.eric.etatFi.controller;

import com.eric.etatFi.Dto.BilanBalanceDto;
import com.eric.etatFi.Dto.BilanDto;
import com.eric.etatFi.entity.Bilan;
import com.eric.etatFi.service.BilanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "bilan")
public class BilanController {
    private BilanService bilanService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ajoutBilan(@RequestBody BilanDto bilanDto) {
        bilanService.ajoutBilan(bilanDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prendreBilan() {
        List<Bilan> bilans = bilanService.prendreBilans();

        return ResponseEntity.ok(bilans);
    }

    @GetMapping(path = "balance", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prendreBalance() {
        BilanBalanceDto bilanBalanceDto = bilanService.balance();

        return ResponseEntity.ok(bilanBalanceDto);
    }
}
