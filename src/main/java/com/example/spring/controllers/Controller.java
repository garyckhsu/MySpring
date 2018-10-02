package com.example.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.models.Genre;
import com.example.spring.repositories.GenreRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class Controller {

	@Autowired
	GenreRepository genreRepository;

	@GetMapping("/listAll")
	public List<Genre> getAllGenre() {
		return genreRepository.findAll();
	}

    @GetMapping(value="/list/{type}")
    public List<Genre> getGenreByType(@PathVariable("type") String type) {
        return genreRepository.findByTypeQuery(type);
    }
}