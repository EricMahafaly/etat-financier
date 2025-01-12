package com.eric.etatFi.service;

import com.eric.etatFi.Dto.CompteResultatDto;
import com.eric.etatFi.entity.CompteResultat;
import com.eric.etatFi.entity.ResultatCompteResultat;
import com.eric.etatFi.entity.RubriqueCompte;
import com.eric.etatFi.repository.CompteResultatRepository;
import com.eric.etatFi.repository.ResultatCompteResultatRepository;
import com.eric.etatFi.repository.RubriqueCompteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompteResultatService {
    private CompteResultatRepository compteResultatRepository;
    private RubriqueCompteRepository rubriqueCompteRepository;
    private ResultatCompteResultatRepository resultatCompteResultatRepository;

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
        this.calculAutomatiqueCompteResultat();
        return compteResultatRepository.findAll();
    }

    public void calculAutomatiqueCompteResultat() {
        double resultatExploitation = compteResultatRepository.getMontantCompteResultat("Chiffre affaires") -
                (compteResultatRepository.getMontantCompteResultat("Cout des ventes") +
                        compteResultatRepository.getMontantCompteResultat("Salaires") +
                        compteResultatRepository.getMontantCompteResultat("Autres charges"));
        double resultatAvantImpot = resultatExploitation -
                compteResultatRepository.getMontantCompteResultat("Charges financieres");
        double resultatNet = resultatAvantImpot -
                compteResultatRepository.getMontantCompteResultat("Impot sur les societes");

        System.out.println(resultatExploitation + "\n" + resultatAvantImpot + "\n" + resultatNet);
        List<ResultatCompteResultat> resultatCompteResultats = new ArrayList<>();
        resultatCompteResultats.add(new ResultatCompteResultat("Resultat exploitation", resultatExploitation));
        resultatCompteResultats.add(new ResultatCompteResultat("Resultat avant imppot", resultatAvantImpot));
        resultatCompteResultats.add(new ResultatCompteResultat("Resultat net", resultatNet));
        resultatCompteResultatRepository.deleteAll();
        resultatCompteResultatRepository.saveAll(resultatCompteResultats);
    }
}
