package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.enmus.Role;
import org.sid.pfe_version_2_backend.entities.Client_Professionnel;
import org.sid.pfe_version_2_backend.services.ClientProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ClientProfessionnel")
public class ClientProfessionnelController {
    @Autowired
    ClientProfessionnelService clientProfessionnelService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/{id}")
    public ResponseEntity<Client_Professionnel> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientProfessionnelService.getClientById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client_Professionnel> saveClient(@RequestBody Client_Professionnel newClient) {
        newClient.setRole(Role.USER);
        newClient.setMot_de_passe(passwordEncoder.encode(newClient.getMot_de_passe()) );
        Client_Professionnel savedClient = clientProfessionnelService.SaveClient(newClient);
        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("ClientsPro" ,"/clientsPro" + savedClient.getId_client().toString());
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Client_Professionnel> updatedClient (@PathVariable Long id , @RequestBody Client_Professionnel detailsClient ){
        clientProfessionnelService.updateClient(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Client_Professionnel> deleteClient(@PathVariable Long id ){
        clientProfessionnelService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
