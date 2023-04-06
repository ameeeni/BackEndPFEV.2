package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;

public interface CompteService {
    Compte getCompteById(Long id ) throws CompteBancaireNotFoundException;
    Compte saveCompte(Compte newCompte, Long id_client) throws ClientNotfoundException;
    void updateCompte(Long id , Compte detailsCompte);
    void deleteCompte(Long id);
}
