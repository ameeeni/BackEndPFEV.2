package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Virement_Permanent extends Virement {
    private Date date1;
    private Date date2;
}
