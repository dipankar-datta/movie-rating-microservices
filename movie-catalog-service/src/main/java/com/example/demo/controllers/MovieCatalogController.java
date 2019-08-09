package com.example.demo.controllers;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/user/100", UserRating.class);

        return userRating.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Test description", rating.getRating());
                }).collect(Collectors.toList());

/*        return Arrays.asList(
                new CatalogItem("Transformers", "It's movie on alien robots", 4),
                new CatalogItem("Avengers", "It's movie on multiple super heroes", 5),
                new CatalogItem("Fast & Furious", "It's movie on super cars and lots of actions", 4),
                new CatalogItem("Bat Man", "It's movie on a billionaire with a mission to eliminate crime.", 5),
                new CatalogItem("Spider Man", "It's movie on a young boy who got infected by a spider and mutated to special powers and decides to fight chrime.", 4)
        );*/
    }
}
