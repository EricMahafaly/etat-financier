INSERT INTO rubrique(id_rubrique, nom_rubrique, type_rubrique) VALUES 
    (DEFAULT, 'Actifs non courants', 'Actif'),
    (DEFAULT, 'Actifs courants', 'Actif'),
    (DEFAULT, 'Capitaux propres', 'Passif'),
    (DEFAULT, 'Dettes a court termes', 'Passif')
    (DEFAULT, 'Dettes a long termes', 'Passif')
;

INSERT INTO bilan(id_bilan, id_rubrique, poste, montant) VALUES
    (DEFAULT, 1, 'Immobilisations corporelles', 3500000000),
    (DEFAULT, 1, 'Immobilisations incorporelles', 500000000),
    (DEFAULT, 2, 'Stocks', 1200000000),
    (DEFAULT, 2, 'Clients et autres creances', 2000000000),
    (DEFAULT, 2, 'Disponibilites (banque et caisse)', 1500000000),
    (DEFAULT, 3, 'Capital social', 5000000000),
    (DEFAULT, 3, 'Reserves', 1000000000),
    (DEFAULT, 3, 'Resultat net', 800000000),
    (DEFAULT, 4, 'Dettes financieres', 2000000000),
    (DEFAULT, 4, 'Dettes fournisseurs', 800000000),
    (DEFAULT, 4, 'Dettes fiscales', 100000000)
;

INSERT INTO rubrique_compte_resultat(id_rubrique_compte_resultat, nom_rubrique_cpt) VALUES 
    (DEFAULT, 'Chiffre affaires'),
    (DEFAULT, 'Charges exploitation'),
    (DEFAULT, 'Resultat exploitation'),
    (DEFAULT, 'Resultat net'),
    (DEFAULT, 'Charges financieres'),
    (DEFAULT, 'Impots sur les benefices')
;