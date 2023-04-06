package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.CompteProfessionnel;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;

public interface CompteProfessionnelService {
    CompteProfessionnel getCompteById(Long id ) throws CompteBancaireNotFoundException;
    CompteProfessionnel saveCompte(CompteProfessionnel newCompte );
    void updateCompte(Long id , CompteProfessionnel detailsCompte);
    void deleteCompte(Long id);
}
