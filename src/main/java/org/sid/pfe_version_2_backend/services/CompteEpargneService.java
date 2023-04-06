package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.CompteEpargne;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;

public interface CompteEpargneService {
    CompteEpargne getCompteById(Long id ) throws CompteBancaireNotFoundException;
    CompteEpargne saveCompte(CompteEpargne newCompte );
    void updateCompte(Long id , CompteEpargne detailsCompte);
    void deleteCompte(Long id);
}
