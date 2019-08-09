package com.example.demo.controllers;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/user/{userId}")
    public UserRating getRatings(@PathVariable String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating( Arrays.asList(
                new Rating("100", 4),
                new Rating("101", 5),
                new Rating("102", 4),
                new Rating("103", 5),
                new Rating("104", 4)
        ));
        return userRating;
    }
}
