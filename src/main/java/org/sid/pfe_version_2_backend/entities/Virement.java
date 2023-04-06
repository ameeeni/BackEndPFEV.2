package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.pfe_version_2_backend.enmus.TypeVirement;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Virement extends TransactionBancaire{
    @Enumerated(EnumType.STRING)

    private TypeVirement typeVirement;
}
