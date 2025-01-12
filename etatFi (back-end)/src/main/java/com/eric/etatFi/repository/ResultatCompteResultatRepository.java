package com.eric.etatFi.repository;

import com.eric.etatFi.entity.ResultatCompteResultat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultatCompteResultatRepository extends JpaRepository<ResultatCompteResultat, Integer> {
    ResultatCompteResultat findByRubriqueResultat(String rubriqueResultat);
}
