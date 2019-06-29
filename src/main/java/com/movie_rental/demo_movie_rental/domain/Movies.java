package com.movie_rental.demo_movie_rental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie_rental.demo_movie_rental.domain.enums.MovieGenres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movies implements Serializable{

    @SuppressWarnings("unsed")
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 4, nullable = true)
    private int year;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieGenres genres;

    @OneToMany(mappedBy = "movies")
    @Getter(onMethod = @__({@JsonIgnore}))
    private List<OrderMovie> ordersMovies;

}
