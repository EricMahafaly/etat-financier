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
@Table(name = "bilan")
public class Bilan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBilan;
    @JoinColumn(name = "id_rubrique_bilan")
    @OneToOne
    private RubriqueBilan rubrique;
    @Column(unique = true)
    private String poste;
    private double montant;
}
