package com.movie_rental.demo_movie_rental.repository;

import com.movie_rental.demo_movie_rental.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
}
