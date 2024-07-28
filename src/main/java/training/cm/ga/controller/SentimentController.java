package training.cm.ga.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import training.cm.ga.entites.Sentiment;
import training.cm.ga.enums.TypeSentiment;
import training.cm.ga.services.SentimentService;

import java.util.List;


@RestController
@RequestMapping(path = "sentiment", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SentimentController {

    private SentimentService sentimentService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creerSt(@RequestBody Sentiment sentiment){
        this.sentimentService.creerSt(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.rechercher(type);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimerSt(@PathVariable int id){
        this.sentimentService.supprimer(id);
    }

}
