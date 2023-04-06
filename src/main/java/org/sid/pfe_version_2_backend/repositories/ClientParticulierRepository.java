package org.sid.pfe_version_2_backend.repositories;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.Client_Particulier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientParticulierRepository extends JpaRepository<Client_Particulier,Long> {
}
