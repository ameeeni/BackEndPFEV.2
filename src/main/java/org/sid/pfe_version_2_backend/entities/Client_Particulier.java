package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client_Particulier extends Client{
    private int CIN;
    private Date date_de_naissance ;
    private String lieu_de_naissance;
    private String profession;
    private String status ;

    @OneToMany(mappedBy = "client_particulier" ) /**Le clé etranger dans le bank account **/
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)/*C'est pas important de nous afficher la liste des BankAccount**/
    private List<CompteCourrant> ListeDesComptes;
    @OneToMany(mappedBy = "client_particulier")
    private List<CompteEpargne> compteEpargneList;
    @OneToMany(mappedBy="client_particulier")
    private  List<CompteProfessionnel> compteProfessionnelList;

}
