package org.sid.pfe_version_2_backend.controllers;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.sid.pfe_version_2_backend.entities.Compte;
import org.sid.pfe_version_2_backend.exceptions.SoldeInsufficientException;
import org.sid.pfe_version_2_backend.repositories.VirementPermanentRepository;
import org.sid.pfe_version_2_backend.services.VirementPermanentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/VirementPermanent")
public class VirementPermanentController {
    @Autowired
    VirementPermanentService virementPermanentService;

    public void afficherVirment() throws SoldeInsufficientException {
      System.out.println( virementPermanentService.virementPermanent());

    }





}
