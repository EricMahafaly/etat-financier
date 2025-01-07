package com.eric.etatFi.service;

import com.eric.etatFi.Dto.IndicateurFinanceDto;
import com.eric.etatFi.repository.BilanRepository;
import com.eric.etatFi.repository.CompteResultatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CalculService {
    private CompteResultatRepository compteResultatRepository;
    private BilanRepository bilanRepository;

    public IndicateurFinanceDto margeNette() {
        double resultatNet = compteResultatRepository.getMontantCompteResultat("Resultat net");
        double chiffreAffaire = compteResultatRepository.getMontantCompteResultat("Chiffre affaires");
        double margeNetteMontant = (resultatNet / chiffreAffaire) * 100;

        return new IndicateurFinanceDto("marge nette", margeNetteMontant);
    }

    public IndicateurFinanceDto retourActif() {
        double resultatNet = compteResultatRepository.getMontantCompteResultat("Resultat net");
        double totalActif = bilanRepository.getSommeMontantType("Actif");
        double retourActifMontant = (resultatNet / totalActif) * 100;

        return new IndicateurFinanceDto("retour actif", retourActifMontant);
    }

    public
}
