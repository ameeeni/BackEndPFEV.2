package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.entities.CompteCourrant;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.services.CompteCourrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CompteCourrant")
public class CompteCourrantController {
    @Autowired
    CompteCourrantService compteCourrantService;
    @GetMapping("/{id}")

    public ResponseEntity<CompteCourrant> getCompteById(@PathVariable Long id) throws CompteBancaireNotFoundException {
        return new ResponseEntity<>(compteCourrantService.getCompteById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CompteCourrant> saveCompte(@RequestBody CompteCourrant newCompte )  {
        CompteCourrant savedCompteCourrant = compteCourrantService.saveCompte(newCompte);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ComptesCour" ,"/ComptesCour" + savedCompteCourrant.getId_compte().toString());
        return new ResponseEntity<>(savedCompteCourrant,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompteCourrant> updatedCompteCourrant (@PathVariable Long id , @RequestBody CompteCourrant detailsCompte ){
        compteCourrantService.updateCompte(id,detailsCompte);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<CompteCourrant> deleteCompte(@PathVariable Long id ){
        compteCourrantService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
