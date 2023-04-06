package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;
import org.sid.pfe_version_2_backend.entities.Client_Particulier;

public interface ClientParticulierService {
    Client_Particulier getClientById(Long id);
    Client_Particulier SaveClient(Client_Particulier newClient);
    void updateClient(Long id , Client_Particulier detailsClient);
    void deleteClient(Long id);
}
