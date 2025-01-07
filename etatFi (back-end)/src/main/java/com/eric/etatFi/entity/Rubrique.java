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
@Table(name = "rubrique")
public class Rubrique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRubrique;
    @Column(name = "nom_rubrique")
    private String nomRubrique;
    @Column(name = "type_rubrique")
    private String typeRubrique;
}
