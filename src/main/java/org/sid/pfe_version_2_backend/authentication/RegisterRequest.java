package org.sid.pfe_version_2_backend.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private  String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
}
