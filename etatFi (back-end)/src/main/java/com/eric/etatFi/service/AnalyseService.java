package com.eric.etatFi.service;

import com.eric.etatFi.Dto.IndicateurFinanceDto;
import com.eric.etatFi.entity.ResultatCompteResultat;
import com.eric.etatFi.repository.BilanRepository;
import com.eric.etatFi.repository.CompteResultatRepository;
import com.eric.etatFi.repository.ResultatCompteResultatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnalyseService {
    private BilanRepository bilanRepository;
    private CompteResultatRepository compteResultatRepository;
    private ResultatCompteResultatRepository resultatCompteResultatRepository;

    public IndicateurFinanceDto margeNette() {
        double margeNetteMontant = (resultatCompteResultatRepository.findByRubriqueResultat("Resultat net").getMontant() /
                compteResultatRepository.getMontantCompteResultat("Chiffre affaires")) * 100;

        return new IndicateurFinanceDto("chiffre affaires", margeNetteMontant);
    }

    public IndicateurFinanceDto retourActif() {
        double retourActifMontant = (resultatCompteResultatRepository.findByRubriqueResultat("Resultat net").getMontant() /
                bilanRepository.getSommeMontantType("Actif")) * 100;

        return new IndicateurFinanceDto("Retour sur actif", retourActifMontant);
    }

    public IndicateurFinanceDto retourCapitauxPropre() {
        double retourCapitauxPropreMontant = (resultatCompteResultatRepository.findByRubriqueResultat("Resultat net").getMontant() /
                bilanRepository.findByRubrique_NomRubrique("Capitaux propres").getMontant()) * 100;

        return new IndicateurFinanceDto("Retour sur capitaux propres", retourCapitauxPropreMontant);
    }

    public IndicateurFinanceDto ratioLiquiditeGenerale() {
        double ratioLiquiditeGeneraleMontant = bilanRepository.findByRubrique_NomRubrique("Actifs courants").getMontant() /
                bilanRepository.findByRubrique_NomRubrique("Passifs courants").getMontant();

        return new IndicateurFinanceDto("Ratio de liquidité générale", ratioLiquiditeGeneraleMontant);
    }

//    public IndicateurFinanceDto ratioLiquiditeReduite() {
//        double ratioLiquiditeReduiteMontant =
//    }

    public IndicateurFinanceDto ratioEndettementGlobal() {
        double ratioEndettementGlobalMontant = (bilanRepository.getSommeMontantType("Passif") /
                bilanRepository.getSommeMontantType("Actif")) * 100;

        return new IndicateurFinanceDto("Ratio d’endettement global", ratioEndettementGlobalMontant);
    }

    public IndicateurFinanceDto couvertureInterets() {
        double couvertureInteretsMontant = resultatCompteResultatRepository.findByRubriqueResultat("Resultat exploitation").getMontant() /
                compteResultatRepository.getMontantCompteResultat("Charges financieres");

        return new IndicateurFinanceDto("Couverture des interet", couvertureInteretsMontant);
    }
}
