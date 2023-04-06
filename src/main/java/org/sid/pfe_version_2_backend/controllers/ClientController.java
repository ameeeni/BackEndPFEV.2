package org.sid.pfe_version_2_backend.controllers;

import org.sid.pfe_version_2_backend.enmus.Role;
import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
        ("/Clients")
public class ClientController {
    @Autowired
    ClientService clientService ;
    @Autowired
    PasswordEncoder passwordEncoder ;
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getClientById(id) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client newClient) {
        //jwt
        newClient.setRole(Role.USER);
        newClient.setMot_de_passe(passwordEncoder.encode(newClient.getMot_de_passe()) );
        Client savedClient = clientService.SaveClient(newClient);
        //HttpHeaders httpHeaders = new HttpHeaders();
       // httpHeaders.add("Clients" ,"/clients" + savedClient.getId_client().toString());
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")

    public ResponseEntity<Client> updatedClient (@PathVariable Long id , @RequestBody Client detailsClient ){
        clientService.updateClient(id,detailsClient);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_USER')")

    public  ResponseEntity<Client> deleteClient(@PathVariable Long id ){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
