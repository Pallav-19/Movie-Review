package com.movie.movie.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movie.movies.models.Movie;
@Service
public class MovieServices {
	@Autowired
	private MovieRepository movieRepo;
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}
	public Optional<Movie> getOne(String id) {
		return movieRepo.findByImdbId(id);
	}
	
}
