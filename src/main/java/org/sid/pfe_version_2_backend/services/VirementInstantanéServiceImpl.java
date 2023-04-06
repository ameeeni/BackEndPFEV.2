package org.sid.pfe_version_2_backend.services;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableScheduling
@Transactional
public class VirementInstantanéServiceImpl  implements VirementInstantanéService{
    @Override
    public void virementInstantane(Long id_compteSource, Long id_compteDestination, double montant) {

    }
}
