package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.CompteCourrant;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.sid.pfe_version_2_backend.repositories.CompteCourrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteCourrantServiceImpl implements CompteCourrantService {
    @Autowired
    CompteCourrantRepository compteCourrantRepository;
    @Autowired
    ClientRepository clientRepository;
    @Override
    public CompteCourrant getCompteById(Long id) throws CompteBancaireNotFoundException {
        CompteCourrant compteCourrant= compteCourrantRepository.findById(id)
                .orElseThrow(()-> new CompteBancaireNotFoundException("Compte not Found"));
        return compteCourrant;
    }

    @Override
    public CompteCourrant saveCompte(CompteCourrant newCompte)  {
        /*Client client = clientRepository.findById(id_client).orElseThrow(null);
       if (client==null){
           throw new ClientNotfoundException("Client Not found");
        }*/
        return compteCourrantRepository.save(newCompte);
    }

    @Override
    public void updateCompte(Long id, CompteCourrant detailsCompte) {
        CompteCourrant updatedCompte = compteCourrantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Compte with id "+ id+ " does not exist"));
        updatedCompte.setId_compte(detailsCompte.getId_compte());
        updatedCompte.setSolde(detailsCompte.getSolde());
        updatedCompte.setDate_de_creation(detailsCompte.getDate_de_creation());
        updatedCompte.setDebit(detailsCompte.getDebit());
        compteCourrantRepository.save(updatedCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteCourrantRepository.deleteById(id);
    }
}
