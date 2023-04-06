package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.CompteCourrant;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;

public interface CompteCourrantService {
    CompteCourrant getCompteById(Long id ) throws CompteBancaireNotFoundException;
    CompteCourrant saveCompte(CompteCourrant newCompte  );
    void updateCompte(Long id , CompteCourrant detailsCompte);
    void deleteCompte(Long id);
}
