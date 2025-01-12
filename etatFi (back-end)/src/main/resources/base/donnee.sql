INSERT INTO rubrique_bilan(id_rubrique_bilan, nom_rubrique, type_rubrique) VALUES 
    (DEFAULT, 'Actifs courants', 'Actif'),
    (DEFAULT, 'Actifs non courants', 'Actif'),
    (DEFAULT, 'Passifs courants', 'Passif'),
    (DEFAULT, 'Passifs non courants', 'Passif'),
    (DEFAULT, 'Capitaux propres', 'Passif')
;

INSERT INTO rubrique_compte_resultat(id_rubrique_compte_resultat, nom_rubrique_cpt) VALUES 
    (DEFAULT, 'Chiffre affaires'),
    (DEFAULT, 'Cout des ventes'),
    (DEFAULT, 'Salaires'),
    (DEFAULT, 'Autres charges'),
    (DEFAULT, 'Charges financieres'),
    (DEFAULT, 'Impot sur les societes')
;