package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.entities.CompteEpargne;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.services.CompteEpargneService;
import org.sid.pfe_version_2_backend.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CompteEpargne")
public class CompteEpargneController {
    @Autowired
    CompteEpargneService compteEpargneService;
    @GetMapping("/{id}")
    public ResponseEntity<CompteEpargne> getCompteById(@PathVariable Long id) throws CompteBancaireNotFoundException {
        return new ResponseEntity<>(compteEpargneService.getCompteById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CompteEpargne> saveCompte(@RequestBody CompteEpargne newCompte  )  {
        CompteEpargne savedCompteEpargne = compteEpargneService.saveCompte(newCompte);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("comptesEpar" ,"/comptesEpar" + savedCompteEpargne.getId_compte().toString());
        return new ResponseEntity<>(savedCompteEpargne,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompteEpargne> updatedCompte (@PathVariable Long id , @RequestBody CompteEpargne detailsCompte ){
        compteEpargneService.updateCompte(id,detailsCompte);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<CompteEpargne> deleteCompte(@PathVariable Long id ){
        compteEpargneService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
