package org.sid.pfe_version_2_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CompteProfessionnel extends Compte{
    private float debit;
    @JsonIgnoreProperties("client_particulier")
    @ManyToOne
    private Client_Particulier client_particulier;

    @ManyToOne
    private Client_Professionnel client_professionnel;
    @JsonIgnore
    @OneToMany(mappedBy = "compteProfessionnel")
    private List<TransactionBancaire> transactionBancaireList;
}
