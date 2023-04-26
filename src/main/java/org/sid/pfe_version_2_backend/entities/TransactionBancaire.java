package org.sid.pfe_version_2_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.pfe_version_2_backend.enmus.TypeTransaction;
import org.springframework.context.annotation.ComponentScan;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class TransactionBancaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;
    private Date date_de_transaction;
    private String lieu_de_transaction;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    @JsonIgnore
    @ManyToOne
    private CompteCourrant compteCourrant;
    @JsonBackReference
    @ManyToOne
    private CompteEpargne compteEpargne;
    @JsonIgnore
    @ManyToOne
    private  CompteProfessionnel compteProfessionnel;


}
