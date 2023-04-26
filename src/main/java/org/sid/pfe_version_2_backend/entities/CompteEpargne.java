package org.sid.pfe_version_2_backend.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteEpargne extends Compte implements Serializable {
    private float taux_interet;

    @ManyToOne
    private Client_Particulier client_particulier;

    @ManyToOne
    private Client_Professionnel client_professionnel;
//    @JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
   @JsonBackReference
   @OneToMany(mappedBy = "compteEpargne" ,  fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)/*C'est pas important de nous afficher la liste des BankAccount**/
    private List<TransactionBancaire> transactionBancaireList;
}

