package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.entities.CompteProfessionnel;
import org.sid.pfe_version_2_backend.entities.TransactionBancaire;
import org.sid.pfe_version_2_backend.repositories.TransactionBancaireRepository;
import org.sid.pfe_version_2_backend.services.TransactionBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transactionbancaire")
@RestController
public class TransactionBancaireController {
   @Autowired
    TransactionBancaireService transactionBancaireService;
    @GetMapping
    public ResponseEntity<List<TransactionBancaire>> getAllTransactionsBancaires() {
        List<TransactionBancaire> allTransactionBancaire = transactionBancaireService.getAllTransactionBancaire();
        return new ResponseEntity<>(allTransactionBancaire, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionBancaire> geTransactionBancaireById(@PathVariable Long id){
        return new ResponseEntity<>(transactionBancaireService.getTransactionBancaireById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TransactionBancaire> saveTransactionBancaire(@RequestBody TransactionBancaire transactionBancaire)  {
        TransactionBancaire savedTransaction = transactionBancaireService.saveTransactions(transactionBancaire);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("comptesPro" ,"/comptesPro" + savedTransaction.getId_transaction().toString());
        return new ResponseEntity<>(savedTransaction,httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/compte/{id_compte}")

    public ResponseEntity<List<TransactionBancaire>> geTransactionBancaireByCompteEpargne(@PathVariable Long id_compte){
        return new ResponseEntity<>(transactionBancaireService.getTransactionBancaireByCompteEpargne(id_compte) , HttpStatus.OK);
    }



}
