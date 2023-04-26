package org.sid.pfe_version_2_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteCourrant extends Compte{
    private float debit;

    @ManyToOne
    private Client_Particulier client_particulier;

    @ManyToOne
    Client_Professionnel client_professionnel;

    @OneToMany(mappedBy = "compteCourrant")
    private List<TransactionBancaire> transactionBancaireList;


}
