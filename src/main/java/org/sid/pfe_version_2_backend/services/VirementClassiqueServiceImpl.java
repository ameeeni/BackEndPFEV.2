package org.sid.pfe_version_2_backend.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VirementClassiqueServiceImpl implements VirementClassiqueService
{
    @Override
    public void virementClassique(Long id_compteSource, Long id_compteDestination, double montant) {

    }
}
