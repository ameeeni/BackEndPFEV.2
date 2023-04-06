package org.sid.pfe_version_2_backend;

import lombok.extern.slf4j.Slf4j;
import org.sid.pfe_version_2_backend.controllers.VirementPermanentController;
import org.sid.pfe_version_2_backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

@Slf4j
public class PfeVersion2BackendApplication {
@Autowired
ClientRepository clientRepository;
@Autowired
ClientProfessionnelRepository clientProfessionnelRepository;
@Autowired
ClientParticulierRepository clientParticulierRepository;

@Autowired
    CompteRepository compteRepository;
@Autowired
    CompteCourrantRepository compteCourrantRepository;
@Autowired
CompteEpargneRepository  compteEpargneRepository;
@Autowired
CompteProfessionnelRepository compteProfessionnelRepository;
@Autowired
TransactionBancaireRepository transactionBancaireRepository;
@Autowired
    VirementPermanentController virementPermanentController;


    public static void main(String[] args) {
        SpringApplication.run(PfeVersion2BackendApplication.class, args);
    }

   /* @Bean
    CommandLineRunner start (){
        return args -> {
            Client client = new Client();
            client.setNom("Ameni");
            client.setEmail("ameni@gmail.com");
            client.setPrénom("*****");
            client.setMot_de_passe("******");
            clientRepository.save(client);
            Client_Professionnel client_professionnel = new Client_Professionnel();
            client_professionnel.setNom("Amenities");
            client_professionnel.setEmail("amenities@gmail.com");
            client_professionnel.setPrénom("*****");
            client_professionnel.setMot_de_passe("******");
            client_professionnel.setMatricule_fiscale("test");
            client_professionnel.setNum_registre_commerce("55555");
            client_professionnel.setRaison_socile("kkkkkkk");
            clientProfessionnelRepository.save(client_professionnel);
            Client_Particulier client_particulier = new Client_Particulier();
            client_particulier.setNom("Salah");
            client_particulier.setEmail("Salah@gmail.com");
            client_particulier.setPrénom("Mejri");
            client_particulier.setMot_de_passe("*********");
            client_particulier.setProfession("Ingénieur");
            client_particulier.setLieu_de_naissance("Tunis");
            client_particulier.setStatus("married");
            clientParticulierRepository.save(client_particulier);
             Compte compte = new Compte();
             compte.setDate_de_creation(new Date());
             compte.setSolde(222);
             compteRepository.save(compte);
            CompteCourrant compteCourrant = new CompteCourrant();
            compteCourrant.setDebit(22);
            compteCourrant.setDate_de_creation(new Date());
            compteCourrant.setSolde(222);
            compteCourrantRepository.save(compteCourrant);
            CompteProfessionnel compteProfessionnel= new CompteProfessionnel();
            compteProfessionnel.setDebit(2);
            compteProfessionnel.setSolde(222);
            compteProfessionnel.setDate_de_creation(new Date());
            compteProfessionnelRepository.save(compteProfessionnel);
            TransactionBancaire transactionBancaire=new TransactionBancaire();
            transactionBancaire.setLieu_de_transaction("tunisie");
            transactionBancaire.setMontant(222);
            transactionBancaire.setType(TypeTransaction.Virement);
            transactionBancaireRepository.save(transactionBancaire);
            TransactionBancaire transactionBancaire1=new TransactionBancaire();
            transactionBancaire1.setLieu_de_transaction("France");
            transactionBancaire1.setMontant(333);
            transactionBancaire1.setType(TypeTransaction.Versement);
            transactionBancaireRepository.save(transactionBancaire1);


        };
}
     @Bean
    CommandLineRunner commandLineRunner() {
          return args -> {
             virementPermanentController.afficherVirment();
          };
      }*/


}