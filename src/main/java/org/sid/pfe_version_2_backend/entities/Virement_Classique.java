package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

;import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Virement_Classique extends Virement {
    private Date date_execution ;

}
