package com.movie_rental.demo_movie_rental.repository;

import com.movie_rental.demo_movie_rental.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        @Query("select u from user u where email = ?1 and password = ?2")
        Optional<User> login(String email, String password);

        @Transactional(readOnly = false)
        @Modifying
        @Query("update user set password = ?2 where id = ?1")
        int updatePassword(Long id, String password);

}
