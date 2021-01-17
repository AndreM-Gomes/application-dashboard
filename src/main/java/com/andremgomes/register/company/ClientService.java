package com.andremgomes.register.company;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    void registerCompany(Client client){
        clientRepository.persist(client);
    }

    List<Client> getAllCompanies(){
        return clientRepository.findAll().list();
    }

    @Transactional
    public byte[] getLogoById(Long companyId) {
        return this.clientRepository
                .findByIdOptional(companyId)
                .map(client -> client.icon)
                .orElseThrow(() -> new ResponseProcessingException(
                        Response
                                .status(404)
                                .build(),
                        "Não foi encontrada a logo da empresa de id: " + companyId)
                );
    }

    @Transactional
    public void updateCompany(Client toClient, Long companyId) {
        this.clientRepository.findByIdOptional(companyId)
                .ifPresent(client -> {
                    client.icon = toClient.icon;
                    client.name = toClient.name;
                    client.persist();
                });
    }

    @Transactional
    public void deleteCompany(Long id) {
        this.clientRepository.deleteById(id);
    }
}
