package com.movie_rental.demo_movie_rental.service;

import com.movie_rental.demo_movie_rental.domain.Movies;
import com.movie_rental.demo_movie_rental.exception.NotFoundException;
import com.movie_rental.demo_movie_rental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movies save(Movies movies){
        return movieRepository.save(movies);
    }

    public Movies update(Movies movies){
        return movieRepository.save(movies);
    }

    public Movies getMovieById(Long id){
        Optional<Movies> result = movieRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException("There are not movie with id " + id));
    }

    public List<Movies> getAllMovies(){
        return movieRepository.findAll();
    }
}
