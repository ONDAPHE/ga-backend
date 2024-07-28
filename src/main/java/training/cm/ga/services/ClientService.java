package training.cm.ga.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import training.cm.ga.entites.Client;
import training.cm.ga.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    public void creerClt(Client client){
        Client oldclient = this.clientRepository.findByEmail(client.getEmail());
        if (oldclient==null){
            this.clientRepository.save(client);
        }
    }

    public List<Client>rechercher() {
        return this.clientRepository.findAll();
    }
    public Client lire(int id){
        Optional<Client> optionalClient =  this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreClienter(Client client) {
        Client clientBD = this.clientRepository.findByEmail(client.getEmail());
        if (clientBD==null){
            this.clientRepository.save(client);
        }
        return clientBD;
    }

    public void modifierClt(int id, Client client) {
        Client clientbd = this.lire(id);
        if(clientbd.getId() == client.getId()){
            clientbd.setEmail(client.getEmail());
            clientbd.setTelephone(client.getTelephone());
            this.clientRepository.save(clientbd);
        }
    }
}
