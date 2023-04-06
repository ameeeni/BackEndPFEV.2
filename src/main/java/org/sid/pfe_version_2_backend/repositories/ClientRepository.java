package org.sid.pfe_version_2_backend.repositories;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.sid.pfe_version_2_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findClientByEmail(String email);
}
