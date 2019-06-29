package com.movie_rental.demo_movie_rental.repository;

import com.movie_rental.demo_movie_rental.domain.OrderMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMovieRepository  extends JpaRepository<OrderMovie,Long> {

    List<OrderMovie> findByCustomerId(Long id);

    List<OrderMovie> findByMoviesId(Long id);

}
