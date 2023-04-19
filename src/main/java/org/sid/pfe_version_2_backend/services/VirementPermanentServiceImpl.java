package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.entities.TransactionBancaire;
import org.sid.pfe_version_2_backend.exceptions.SoldeInsufficientException;
import org.sid.pfe_version_2_backend.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.TimerTask;

@Service
@Transactional
@EnableScheduling

public class VirementPermanentServiceImpl implements VirementPermanentService {
    @Autowired
    CompteRepository compteRepository;
    Compte compte = new Compte();
    TransactionBancaire trc = new TransactionBancaire();


    //@Scheduled(fixedDelay = 3000, initialDelay = 5000)
    @Override


    public double virementPermanent() throws SoldeInsufficientException {
      TimerTask task = new TimerTask() {
          @Override
          public void run() {
              compte.setSolde(555-100);
              System.out.println("***********" + compte.getSolde());
          }
      };

       /* {

            if (compte.getSolde() < trc.getMontant()) {
                throw new SoldeInsufficientException("Votre Solde est insufficient");
            } else {
                compte.setSolde((compte.getSolde() - trc.getMontant()));

            }
            compteRepository.save(compte);
            System.out.println("***********" + compte.getSolde());


            return compte.getSolde();
        }*/
        Timer timer = new Timer("Timer");

        timer.scheduleAtFixedRate(task, 10, 10);


        return compte.getSolde();
    }


}
