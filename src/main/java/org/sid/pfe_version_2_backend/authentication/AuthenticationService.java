package org.sid.pfe_version_2_backend.authentication;

import lombok.RequiredArgsConstructor;
import org.sid.pfe_version_2_backend.enmus.Role;
import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.repositories.ClientRepository;
import org.sid.pfe_version_2_backend.services.JwtService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final ClientRepository repository;
  private final PasswordEncoder passwordEncoder;
  private  final JwtService jwtService;
  private  final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Client user = new Client();
        user.builder()
                .nom(request.getNom())
                .prénom(request.getPrenom())
                .email(request.getEmail())
                .mot_de_passe(passwordEncoder.encode(request.getMot_de_passe()))
                .role(Role.USER)
                .build();
        System.out.println("el USER YA KHRA " + request.getEmail());
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken) //il va prendre le token généré lors de la register.
                .build();

    }

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMot_de_passe()
                )

        );

        var user = repository.findClientByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken) //il va prendre le token généré lors de la register.
                .build();
    }
}
