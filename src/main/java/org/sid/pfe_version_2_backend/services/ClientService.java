package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client;

public interface ClientService {
    Client getClientById(Long id);
    Client SaveClient(Client newClient);
    void updateClient(Long id , Client detailsClient);
    void deleteClient(Long id);
}
