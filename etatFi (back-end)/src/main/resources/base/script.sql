\c postgres;
DROP DATABASE etatfi;

CREATE DATABASE etatfi;
\c etatfi;

CREATE TABLE rubrique_bilan (
    id_rubrique_bilan SERIAL PRIMARY KEY,
    nom_rubrique VARCHAR(255),
    type_rubrique VARCHAR(255)
);

CREATE TABLE bilan (
    id_bilan SERIAL PRIMARY KEY,
    id_rubrique_bilan INTEGER,
    poste VARCHAR(255),
    montant DOUBLE PRECISION,
    FOREIGN KEY (id_rubrique_bilan) REFERENCES rubrique_bilan(id_rubrique_bilan)
);

CREATE TABLE rubrique_compte_resultat (
    id_rubrique_compte_resultat SERIAL PRIMARY KEY,
    nom_rubrique_cpt VARCHAR(255)
);

CREATE TABLE compte_resultat (
    id_compte_resultat SERIAL PRIMARY KEY,
    id_rubrique_compte_resultat INTEGER,
    montant DOUBLE PRECISION,
    FOREIGN KEY (id_rubrique_compte_resultat) REFERENCES rubrique_compte_resultat(id_rubrique_compte_resultat)
);

CREATE TABLE resultat_compte_resultat (
    id_resultat_compte_resultat SERIAL PRIMARY KEY,
    nom_rubrique_rcpt VARCHAR(255),
    montant DOUBLE PRECISION
);