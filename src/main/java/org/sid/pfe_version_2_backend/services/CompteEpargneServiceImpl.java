package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.CompteEpargne;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.sid.pfe_version_2_backend.repositories.CompteEpargneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CompteEpargneServiceImpl implements  CompteEpargneService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteEpargneRepository compteEpargneRepository;
    @Override
    public CompteEpargne getCompteById(Long id) throws CompteBancaireNotFoundException {
        CompteEpargne compteEpargne= compteEpargneRepository.findById(id)
                .orElseThrow(()-> new CompteBancaireNotFoundException("Compte not Found"));
        return compteEpargne;

    }

    @Override
    public CompteEpargne saveCompte(CompteEpargne newCompte ) {
        /*Client client = clientRepository.findById(id_client).orElseThrow(null);
        if (client==null){
            throw new ClientNotfoundException("Client Not found");
        }*/
        return compteEpargneRepository.save(newCompte);

    }

    @Override
    public void updateCompte(Long id, CompteEpargne detailsCompte) {
        CompteEpargne updatedCompte = compteEpargneRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Compte with id "+ id+ " does not exist"));
        updatedCompte.setId_compte(detailsCompte.getId_compte());
        updatedCompte.setSolde(detailsCompte.getSolde());
        updatedCompte.setDate_de_creation(detailsCompte.getDate_de_creation());
        updatedCompte.setTaux_interet(detailsCompte.getTaux_interet());
        compteEpargneRepository.save(updatedCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteEpargneRepository.deleteById(id);
    }
}
