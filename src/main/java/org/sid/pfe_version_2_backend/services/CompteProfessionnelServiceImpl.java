package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.CompteProfessionnel;
import org.sid.pfe_version_2_backend.exceptions.CompteBancaireNotFoundException;
import org.sid.pfe_version_2_backend.exceptions.ClientNotfoundException;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.sid.pfe_version_2_backend.repositories.CompteProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@Transactional
@CrossOrigin
public class CompteProfessionnelServiceImpl implements CompteProfessionnelService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CompteProfessionnelRepository compteProfessionnelRepository;
    @CrossOrigin(origins = "http://localhost:8100")
    @Override
    public CompteProfessionnel getCompteById(Long id) throws CompteBancaireNotFoundException {
       CompteProfessionnel compteProfessionnel= compteProfessionnelRepository.findById(id)
                .orElseThrow(()-> new CompteBancaireNotFoundException("Compte not Found"));
       return compteProfessionnel;
    }

    @Override
    public CompteProfessionnel saveCompte(CompteProfessionnel newCompte)  {
        /*Client client = clientRepository.findById(id_client).orElseThrow(null);
        if (client==null){
            throw new ClientNotfoundException("Client Not found");
        }*/
        return compteProfessionnelRepository.save(newCompte);
    }

    @Override
    public void updateCompte(Long id, CompteProfessionnel detailsCompte) {
        CompteProfessionnel updatedCompte = compteProfessionnelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Compte with id "+ id+ " does not exist"));
        updatedCompte.setId_compte(detailsCompte.getId_compte());
        updatedCompte.setSolde(detailsCompte.getSolde());
        updatedCompte.setDate_de_creation(detailsCompte.getDate_de_creation());
        updatedCompte.setDebit(detailsCompte.getDebit());
        compteProfessionnelRepository.save(updatedCompte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteProfessionnelRepository.deleteById(id);
    }
}
