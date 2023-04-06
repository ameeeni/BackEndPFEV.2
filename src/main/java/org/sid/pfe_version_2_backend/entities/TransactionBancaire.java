package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.pfe_version_2_backend.enmus.TypeTransaction;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class TransactionBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaction;
    private Date date_de_transaction;
    private String lieu_de_transaction;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    @ManyToOne
    private CompteCourrant compteCourrant;
    @ManyToOne
    private CompteEpargne compteEpargne;
    @ManyToOne
    private  CompteProfessionnel compteProfessionnel;


}
