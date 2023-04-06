package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.exceptions.SoldeInsufficientException;

public interface VirementPermanentService {
    double virementPermanent() throws SoldeInsufficientException;

}
