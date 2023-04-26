package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.entities.CompteProfessionnel;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.services.CompteProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CompteProfessionnel")
@CrossOrigin(origins = "http://localhost:8100")
public class CompteProfessionnelController {
    @Autowired
     CompteProfessionnelService compteProfessionnelService;
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/{id}")
    public ResponseEntity<CompteProfessionnel> getCompteProfessionnelById(@PathVariable Long id) throws CompteBancaireNotFoundException {
        return new ResponseEntity<>(compteProfessionnelService.getCompteById(id) , HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping

    public ResponseEntity<CompteProfessionnel> saveCompteProfessionnel(@RequestBody CompteProfessionnel newCompte)  {
        CompteProfessionnel savedCompte = compteProfessionnelService.saveCompte(newCompte);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("comptesPro" ,"/comptesPro" + savedCompte.getId_compte().toString());
        return new ResponseEntity<>(savedCompte,httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompteProfessionnel> updatedCompteProfessionnel (@PathVariable Long id , @RequestBody CompteProfessionnel detailsCompte ){
        compteProfessionnelService.updateCompte(id,detailsCompte);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<CompteProfessionnel> deleteCompteProfessionnel(@PathVariable Long id ){
        compteProfessionnelService.deleteCompte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
