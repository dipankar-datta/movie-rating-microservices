package com.example.demo.controllers;

import com.example.demo.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        return Arrays.asList(
                new CatalogItem("Transformers", "It's movie on alien robots", 4),
                new CatalogItem("Avengers", "It's movie on multiple super heroes", 5),
                new CatalogItem("Fast & Furious", "It's movie on super cars and lots of actions", 4)
        );
    }
}
