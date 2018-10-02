package com.example.spring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring.models.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, String> {
	
	@Query("{type : ?0}")
    public List<Genre> findByTypeQuery(String type);
	
}