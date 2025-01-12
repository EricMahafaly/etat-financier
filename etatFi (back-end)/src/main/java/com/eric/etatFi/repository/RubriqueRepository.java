package com.eric.etatFi.repository;

import com.eric.etatFi.entity.RubriqueBilan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubriqueRepository extends JpaRepository<RubriqueBilan, Integer> {
}
