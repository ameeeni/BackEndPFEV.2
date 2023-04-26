package org.sid.pfe_version_2_backend.repositories;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.TransactionBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionBancaireRepository extends JpaRepository<TransactionBancaire,Long> {
    List<TransactionBancaire> getTransactionBancaireByCompteEpargne(Long id_compte);
}
