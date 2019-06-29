package com.movie_rental.demo_movie_rental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie_rental.demo_movie_rental.domain.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "order_movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderMovie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOrder status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @Getter(onMethod = @__({@JsonIgnore}))
    private Movies movies;


}
