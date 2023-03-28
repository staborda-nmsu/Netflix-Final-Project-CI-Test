package com.company.gameStore.controllers;

import com.company.gameStore.models.Game;
import com.company.gameStore.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameRepository repo;

    @GetMapping("/games")
    public List<Game> getGames() {
        return repo.findAll();
    }

    @GetMapping("/games/studio/{studio}")
    public Game getGameByStudio(@PathVariable String studio) {
        Optional<Game> returnVal = repo.findByStudio(studio);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    @GetMapping("/games/esrb/{esrb}")
    public Game getGameByESRB(@PathVariable String esrb) {
        Optional<Game> returnVal = repo.findByEsrbRating(esrb);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
    @GetMapping("/games/title/{title}")
    public Game getGameByTitle(@PathVariable String title) {
        Optional<Game> returnVal = repo.findByTitle(title);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addPublisher(@RequestBody Game Publisher) {
        return repo.save(Publisher);
    }

    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Game Publisher) {
        repo.save(Publisher);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }
}
