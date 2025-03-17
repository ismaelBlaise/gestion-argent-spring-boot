CREATE TABLE utilisateurs (
                              id_utilisateur SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                              nom TEXT NOT NULL,
                              email TEXT UNIQUE NOT NULL,
                              mot_de_passe TEXT NOT NULL
);

CREATE TABLE types_revenu (
                              id_type_revenu SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                              nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_depense (
                               id_type_depense SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                               nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_dette (
                             id_type_dette SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                             nom TEXT NOT NULL UNIQUE
);

CREATE TABLE statuts_dette (
                               id_statut SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                               nom TEXT NOT NULL UNIQUE
);

CREATE TABLE types_limite (
                              id_type_limite SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                              nom TEXT NOT NULL UNIQUE
);

CREATE TABLE revenus (
                         id_revenu SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                         montant NUMERIC(15,2) NOT NULL CHECK (montant >= 0),
                         date_revenu TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         id_type_revenu INTEGER NOT NULL,
                         id_utilisateur INTEGER NOT NULL,
                         FOREIGN KEY (id_type_revenu) REFERENCES types_revenu(id_type_revenu) ON DELETE CASCADE,
                         FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE
);

CREATE TABLE depenses (
                          id_depense SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                          montant NUMERIC(15,2) NOT NULL CHECK (montant >= 0),
                          raison TEXT NOT NULL,
                          date_depense TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          id_type_depense INTEGER NOT NULL,
                          id_utilisateur INTEGER NOT NULL,
                          FOREIGN KEY (id_type_depense) REFERENCES types_depense(id_type_depense) ON DELETE CASCADE,
                          FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE
);

CREATE TABLE dettes (
                        id_dette SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                        montant NUMERIC(15,2) NOT NULL CHECK (montant >= 0),
                        raison TEXT NOT NULL,
                        personne TEXT NOT NULL,
                        date_debut TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        date_limite TIMESTAMP NOT NULL,
                        id_utilisateur INTEGER NOT NULL,
                        id_statut INTEGER NOT NULL,
                        id_type_dette INTEGER NOT NULL,
                        FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur) ON DELETE CASCADE,
                        FOREIGN KEY (id_statut) REFERENCES statuts_dette(id_statut) ON DELETE CASCADE,
                        FOREIGN KEY (id_type_dette) REFERENCES types_dette(id_type_dette) ON DELETE CASCADE
);

CREATE TABLE limites_depense (
                                 id_limite_depense SERIAL PRIMARY KEY,  -- Utilisation de SERIAL pour auto-incrémenter
                                 montant NUMERIC(15,2) NOT NULL CHECK (montant >= 0),
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
