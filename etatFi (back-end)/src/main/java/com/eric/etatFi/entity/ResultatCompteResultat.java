package com.eric.etatFi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resultat_compte_resultat")
public class ResultatCompteResultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultat_compte_resultat")
    private int id;
    @Column(name = "nom_rubrique_rcpt")
    private String rubriqueResultat;
    private double montant;

    public ResultatCompteResultat(String rubriqueResultat, double montant) {
        this.rubriqueResultat = rubriqueResultat;
        this.montant = montant;
    }
}
