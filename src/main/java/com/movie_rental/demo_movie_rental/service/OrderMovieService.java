package com.movie_rental.demo_movie_rental.service;

import com.movie_rental.demo_movie_rental.domain.OrderMovie;
import com.movie_rental.demo_movie_rental.domain.enums.StatusOrder;
import com.movie_rental.demo_movie_rental.repository.OrderMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderMovieService {

    @Autowired
    private OrderMovieRepository orderMovieRepository;

    public OrderMovie rentMovie(OrderMovie orderMovie){
        orderMovie.setStatus(StatusOrder.RENTED);
        orderMovie.setOrderDate(new Date());
        return orderMovieRepository.save(orderMovie);
    }

    public OrderMovie returnMovie(OrderMovie orderMovie){
        orderMovie.setStatus(StatusOrder.RETURNED);
        orderMovie.setReturnDate(new Date());
        return orderMovieRepository.save(orderMovie);
    }

    public List<OrderMovie> findByCustomerId(Long id) {
        return orderMovieRepository.findByCustomerId(id);
    }

}
