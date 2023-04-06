package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Compte")
public class CompteController {
    @Autowired
    CompteService compteService;
    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompteById(@PathVariable Long id) throws CompteBancaireNotFoundException {
        return new ResponseEntity<>(compteService.getCompteById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Compte> saveCompte(@RequestBody Compte newCompte ,@PathVariable Long id_client) throws ClientNotfoundException {
        Compte savedCompte = compteService.saveCompte(newCompte, id_client);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("comptes" ,"/comptes" + savedCompte.getId_compte().toString());
        return new ResponseEntity<>(savedCompte,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Compte> updatedCompte (@PathVariable Long id , @RequestBody Compte detailsCompte ){
        compteService.updateCompte(id,detailsCompte);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Compte> deleteCompte(@PathVariable Long id ){
        compteService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
