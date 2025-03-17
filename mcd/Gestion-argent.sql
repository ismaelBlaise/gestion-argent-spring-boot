
CREATE TABLE utilisateurs (
    id_utilisateur INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    mot_de_passe TEXT NOT NULL
);

CREATE TABLE types_revenu (
    id_type_revenu INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_depense (
    id_type_depense INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_dette (
    id_type_dette INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL UNIQUE
);

CREATE TABLE statuts_dette (
    id_statut INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_limite (
    id_type_limite INTEGER PRIMARY KEY AUTOINCREMENT,
    nom TEXT NOT NULL UNIQUE
);

CREATE TABLE revenus (
    id_revenu INTEGER PRIMARY KEY AUTOINCREMENT,
    montant DECIMAL(15,2) NOT NULL CHECK (montant >= 0),
    date_revenu DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_type_revenu INTEGER NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    FOREIGN KEY (id_type_revenu) REFERENCES types_revenu(id_type_revenu) ON DELETE CASCADE,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE
);

CREATE TABLE depenses (
    id_depense INTEGER PRIMARY KEY AUTOINCREMENT,
    montant DECIMAL(15,2) NOT NULL CHECK (montant >= 0),
    raison TEXT NOT NULL,
    date_depense DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_type_depense INTEGER NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    FOREIGN KEY (id_type_depense) REFERENCES types_depense(id_type_depense) ON DELETE CASCADE,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE
);

CREATE TABLE dettes (
    id_dette INTEGER PRIMARY KEY AUTOINCREMENT,
    montant DECIMAL(15,2) NOT NULL CHECK (montant >= 0),
    raison TEXT NOT NULL,
    personne TEXT NOT NULL,
    date_debut DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_limite DATETIME NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    id_statut INTEGER NOT NULL,
    id_type_dette INTEGER NOT NULL,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE,
    FOREIGN KEY (id_statut) REFERENCES statuts_dette(id_statut) ON DELETE CASCADE,
    FOREIGN KEY (id_type_dette) REFERENCES types_dette(id_type_dette) ON DELETE CASCADE
);

CREATE TABLE limites_depense (
    id_limite_depense INTEGER PRIMARY KEY AUTOINCREMENT,
    montant DECIMAL(15,2) NOT NULL CHECK (montant >= 0),
    description TEXT NOT NULL,
    id_type_limite INTEGER NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    FOREIGN KEY (id_type_limite) REFERENCES types_limite(id_type_limite) ON DELETE CASCADE,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE
);

CREATE TABLE depense_revenu (
    id_type_revenu INTEGER,
    id_type_depense INTEGER,
    PRIMARY KEY(id_type_revenu, id_type_depense),
    FOREIGN KEY (id_type_revenu) REFERENCES types_revenu(id_type_revenu) ON DELETE CASCADE,
    FOREIGN KEY (id_type_depense) REFERENCES types_depense(id_type_depense) ON DELETE CASCADE
);
