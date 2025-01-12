package com.eric.etatFi.repository;

import com.eric.etatFi.entity.Bilan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BilanRepository extends JpaRepository<Bilan, Integer> {
    @Query("SELECT SUM(montant) FROM Bilan b WHERE b.rubrique.typeRubrique = :type")
    double getSommeMontantType(@Param("type") String typeRubrique);

    Bilan findByRubrique_NomRubrique(String nomRubrique);
}
