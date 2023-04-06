package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.TransactionBancaire;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionBancaireService {
    List<TransactionBancaire> getAllTransactionBancaire();
    TransactionBancaire getTransactionBancaireById(Long id);
    TransactionBancaire saveTransactions(TransactionBancaire transactionBancaire);
}
