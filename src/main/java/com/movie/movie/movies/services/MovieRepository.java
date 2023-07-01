package com.movie.movie.movies.services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.movie.movies.models.Movie;
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
public Optional<Movie> findByImdbId(String imdbId);
}
