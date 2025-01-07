package com.eric.etatFi.service;

import com.eric.etatFi.Dto.CompteResultatDto;
import com.eric.etatFi.entity.CompteResultat;
import com.eric.etatFi.entity.RubriqueCompte;
import com.eric.etatFi.repository.CompteResultatRepository;
import com.eric.etatFi.repository.RubriqueCompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompteResultatService {
    private CompteResultatRepository compteResultatRepository;
    private RubriqueCompteRepository rubriqueCompteRepository;

    public List<RubriqueCompte> prendreCompteResultatRubriques() {
        return rubriqueCompteRepository.findAll();
    }

    public void ajoutCompte(CompteResultatDto compteResultatDto) {
        CompteResultat compteResultat = new CompteResultat();
        Optional<RubriqueCompte> rubriqueCompte = rubriqueCompteRepository.findById(compteResultatDto.idRubrique());
        compteResultat.setRubriqueCompte(rubriqueCompte.orElseThrow());
        compteResultat.setMontant(compteResultatDto.montant());
        compteResultatRepository.save(compteResultat);
    }

    public List<CompteResultat> prendreCompteResultats() {
        return compteResultatRepository.findAll();
    }
}
