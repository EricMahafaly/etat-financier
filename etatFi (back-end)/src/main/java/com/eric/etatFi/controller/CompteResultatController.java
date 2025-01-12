package com.eric.etatFi.controller;

import com.eric.etatFi.Dto.CompteResultatDto;
import com.eric.etatFi.entity.CompteResultat;
import com.eric.etatFi.entity.RubriqueCompte;
import com.eric.etatFi.service.CompteResultatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "compte-resultat")
public class CompteResultatController {
    private CompteResultatService compteResultatService;

    @GetMapping(path = "rubriques", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prendreCompteResultatRubriques() {
        List<RubriqueCompte> rubriqueComptes = compteResultatService.prendreCompteResultatRubriques();

        return ResponseEntity.ok(rubriqueComptes);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prendreCompteResultats() {
        List<CompteResultat> compteResultats = compteResultatService.prendreCompteResultats();

        return ResponseEntity.ok(compteResultats);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ajoutCompte(@RequestBody CompteResultatDto compteResultatDto) {
        compteResultatService.ajoutCompte(compteResultatDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
