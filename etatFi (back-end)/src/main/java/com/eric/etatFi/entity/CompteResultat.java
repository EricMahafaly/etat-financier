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
@Table(name = "compte_resultat")
public class CompteResultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompteResultat;
    @JoinColumn(name = "id_rubrique_compte_resultat")
    @OneToOne
    private RubriqueCompte rubriqueCompte;
    private double montant;
}
