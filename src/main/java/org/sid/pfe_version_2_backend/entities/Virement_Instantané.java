package org.sid.pfe_version_2_backend.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Virement_Instantané extends Virement{
    private Time temps_instantané;

}
