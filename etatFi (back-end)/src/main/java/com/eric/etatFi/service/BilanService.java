package com.eric.etatFi.service;

import com.eric.etatFi.Dto.BilanBalanceDto;
import com.eric.etatFi.Dto.BilanDto;
import com.eric.etatFi.entity.Bilan;
import com.eric.etatFi.repository.BilanRepository;
import com.eric.etatFi.repository.RubriqueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BilanService {
    private BilanRepository bilanRepository;
    private RubriqueRepository rubriqueRepository;

    public void ajoutBilan(BilanDto bilanDto) {
        Bilan bilan = new Bilan();
        bilan.setRubrique(rubriqueRepository.findById(bilanDto.idRubrique()).orElseThrow());
        bilan.setPoste(bilanDto.poste());
        bilan.setMontant(bilanDto.montant());
        bilanRepository.save(bilan);
    }

    public List<Bilan> prendreBilans() {
        return bilanRepository.findAll();
    }

    public BilanBalanceDto balance() {
        double totalActif = bilanRepository.getSommeMontantType("Actif");
        double totalPassif = bilanRepository.getSommeMontantType("Passif");
        boolean balance = totalActif == totalPassif;

        return new BilanBalanceDto(totalActif, totalPassif, balance);
    }
}
