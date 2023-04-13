package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client_Professionnel extends Client{
    private String matricule_fiscale;
    private String raison_social;
    private String num_registre_commerce;
    @OneToMany(mappedBy = "client_professionnel" ) /**Le clé etranger dans le bank account **/
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)/*C'est pas important de nous afficher la liste des BankAccount**/
    private List<CompteCourrant> ListeDesComptes;
    @OneToMany(mappedBy = "client_professionnel")
    private List<CompteEpargne> compteEpargneList;
    @OneToMany(mappedBy="client_professionnel")
    private  List<CompteProfessionnel> compteProfessionnelList;
}
