package training.cm.ga.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import training.cm.ga.entites.Client;
import training.cm.ga.entites.Sentiment;
import training.cm.ga.enums.TypeSentiment;
import training.cm.ga.repository.SentimentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public void creerSt(Sentiment sentiment){
        Client client = this.clientService.lireOuCreClienter(sentiment.getClient());
        sentiment.setClient(client);
        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null){
            return this.sentimentRepository.findAll();
        }else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
