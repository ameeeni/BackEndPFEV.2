package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.enmus.Role;
import org.sid.pfe_version_2_backend.entities.Client_Particulier;
import org.sid.pfe_version_2_backend.services.ClientParticulierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ClientParticulier")
@RestController
public class ClientParticulierController {
    @Autowired
    ClientParticulierService clientParticulierService;
    @Autowired
    PasswordEncoder passwordEncoder ;
    @GetMapping("/{id}")
    public ResponseEntity<Client_Particulier> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientParticulierService.getClientById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client_Particulier> saveClient(@RequestBody Client_Particulier newClient) {
        newClient.setRole(Role.USER);
        newClient.setMot_de_passe(passwordEncoder.encode(newClient.getMot_de_passe()) );
        Client_Particulier savedClient = clientParticulierService.SaveClient(newClient);
       /* HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("ClientsPar" ,"/ClientsPar" + savedClient.getId_client().toString());*/
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Client_Particulier> updatedClient (@PathVariable Long id , @RequestBody Client_Particulier detailsClient ){
        clientParticulierService.updateClient(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Client_Particulier> deleteClient(@PathVariable Long id ){
        clientParticulierService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
