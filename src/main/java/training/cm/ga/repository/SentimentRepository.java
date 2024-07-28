package training.cm.ga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.cm.ga.entites.Sentiment;
import training.cm.ga.enums.TypeSentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment typeSentiment);
}
