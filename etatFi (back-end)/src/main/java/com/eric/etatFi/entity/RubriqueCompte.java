package com.eric.etatFi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rubrique_compte_resultat")
public class RubriqueCompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rubrique_compte_resultat")
    private int idRubriqueCompte;
    @Column(name = "nom_rubrique_cpt")
    private String nomRubriqueCpt;
}
