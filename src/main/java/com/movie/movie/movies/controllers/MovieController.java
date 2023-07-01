package com.movie.movie.movies.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.movies.models.Movie;
import com.movie.movie.movies.services.MovieServices;


@RestController
@RequestMapping("/api/movie")
@CrossOrigin
public class MovieController {
	 @Autowired
	private MovieServices movieService;

	 @GetMapping
	 @PreAuthorize("hasRole('ROLE_ADMIN')")

	 public ResponseEntity<List<Movie>> allMovies() {
	
		 return new ResponseEntity<List<Movie>>(movieService.getAll(),HttpStatus.OK);
}
	 @GetMapping("/{id}")
	 @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	 public ResponseEntity<Optional<Movie>> oneMovies(@PathVariable String id){
		 return new ResponseEntity<Optional<Movie>>(movieService.getOne(id),HttpStatus.OK);
	 }
	 @GetMapping("/welcome")
	 public String welcome() {
		 return "welcome";
	 }
}
