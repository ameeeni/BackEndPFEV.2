package org.sid.pfe_version_2_backend.services;

import org.sid.pfe_version_2_backend.entities.Client_Professionnel;

public interface ClientProfessionnelService {
    Client_Professionnel getClientById(Long id);
    Client_Professionnel SaveClient(Client_Professionnel newClient);
    void updateClient(Long id , Client_Professionnel detailsClient);
    void deleteClient(Long id);
}
