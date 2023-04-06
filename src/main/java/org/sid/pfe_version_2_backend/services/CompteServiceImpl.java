package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.entities.CompteCourrant;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.sid.pfe_version_2_backend.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CompteServiceImpl implements CompteService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteRepository compteRepository;
    @Override
    public Compte getCompteById(Long id) throws CompteBancaireNotFoundException {

        Compte compte= compteRepository.findById(id)
                .orElseThrow(()-> new CompteBancaireNotFoundException("Compte not Found"));
        return compte;
    }

    @Override
    public Compte saveCompte(Compte newCompte,Long id_client) throws ClientNotfoundException {

        Client client = clientRepository.findById(id_client).orElseThrow(null);
        if (client==null){
            throw new ClientNotfoundException("Client Not found");
        }
        return compteRepository.save(newCompte);
    }

    @Override
    public void updateCompte(Long id, Compte detailsCompte) {
        Compte updatedCompte = compteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Compte with id "+ id+ " does not exist"));
        updatedCompte.setId_compte(detailsCompte.getId_compte());
        updatedCompte.setSolde(detailsCompte.getSolde());
        updatedCompte.setDate_de_creation(detailsCompte.getDate_de_creation());
        compteRepository.save(updatedCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
