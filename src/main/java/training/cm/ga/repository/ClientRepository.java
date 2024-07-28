package training.cm.ga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.cm.ga.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
