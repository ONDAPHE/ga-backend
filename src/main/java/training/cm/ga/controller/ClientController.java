package training.cm.ga.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.cm.ga.dto.ErrorEntity;
import training.cm.ga.entites.Client;
import training.cm.ga.services.ClientService;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creerClt(@RequestBody Client client){
        this.clientService.creerClt(client);

    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> rechercher(){
        return this.clientService.rechercher();
    }
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id){
        return this.clientService.lire(id);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modifierClt(@PathVariable int id, @RequestBody Client client){
        this.clientService.modifierClt(id, client);
    }

}
