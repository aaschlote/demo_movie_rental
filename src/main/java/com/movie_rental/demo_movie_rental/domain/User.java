package com.movie_rental.demo_movie_rental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String name;

    @Column(length = 75, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    @Getter(onMethod = @__({@JsonIgnore}))
    @Setter(onMethod = @__({@JsonProperty}))
    private String password;

    @OneToMany(mappedBy = "customer")
    @Getter(onMethod = @__({@JsonIgnore}))
    private List<OrderMovie> ordersMovie;
}
