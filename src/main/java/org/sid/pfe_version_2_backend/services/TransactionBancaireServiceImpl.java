package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.TransactionBancaire;
import org.sid.pfe_version_2_backend.repositories.TransactionBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TransactionBancaireServiceImpl implements TransactionBancaireService{
    @Autowired
    TransactionBancaireRepository transactionBancaireRepository;
    @Override
    public List<TransactionBancaire> getAllTransactionBancaire() {
        return transactionBancaireRepository.findAll();
    }

    @Override
    public TransactionBancaire getTransactionBancaireById(Long id) {
        return transactionBancaireRepository.findById(id).get();
    }

    @Override
    public TransactionBancaire saveTransactions(TransactionBancaire transactionBancaire) {
        return transactionBancaireRepository.save(transactionBancaire);
    }
}
