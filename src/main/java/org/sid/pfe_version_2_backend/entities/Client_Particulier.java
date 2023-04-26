package org.sid.pfe_version_2_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.MapsId;
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
    @JsonIgnore
    @OneToMany(mappedBy = "client_particulier" , fetch = FetchType.EAGER ) /**Le clé etranger dans le bank account **/
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)/*C'est pas important de nous afficher la liste des BankAccount**/
    private List<CompteCourrant> ListeDesComptes;
    @OneToMany(mappedBy = "client_particulier", fetch = FetchType.EAGER)
    private List<CompteEpargne> compteEpargneList;
    @JsonIgnore
    @OneToMany(mappedBy="client_particulier" , fetch = FetchType.EAGER)
    private  List<CompteProfessionnel> compteProfessionnelList;

}
