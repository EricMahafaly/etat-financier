package com.eric.etatFi.repository;

import com.eric.etatFi.entity.CompteResultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteResultatRepository extends JpaRepository<CompteResultat, Integer> {
    @Query("SELECT montant FROM CompteResultat c WHERE rubriqueCompte.nomRubriqueCpt = :rubriqueCptRes")
    double getMontantCompteResultat(@Param("rubriqueCptRes") String rubriqueCptResultat);
}
