package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteEpargne extends Compte{
    private float taux_interet;
    @ManyToOne
    private Client_Particulier client_particulier;
    @ManyToOne
    private Client_Professionnel client_professionnel;
    @OneToMany(mappedBy = "compteEpargne")
    private List<TransactionBancaire> transactionBancaireList;
}

