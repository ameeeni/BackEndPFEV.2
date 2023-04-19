package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client getClientById(Long id) {
      return clientRepository.findById(id).get();
    }

    @Override
    public Client SaveClient(Client newClient) {
        return  clientRepository.save(newClient);
    }

    @Override
    public void updateClient(Long id, Client detailsClient) {
        Client updateClient = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with id "+ id+ " does not exist"));
        updateClient.setId_client(detailsClient.getId_client());
        updateClient.setNom(detailsClient.getNom());
        updateClient.setPrénom(detailsClient.getPrénom());
        updateClient.setEmail(detailsClient.getEmail());
        updateClient.setPhone(detailsClient.getPhone());
        updateClient.setMot_de_passe(detailsClient.getMot_de_passe());
        clientRepository.save(updateClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
