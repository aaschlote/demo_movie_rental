package com.movie_rental.demo_movie_rental.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.movie_rental.demo_movie_rental.domain.User;
import com.movie_rental.demo_movie_rental.repository.UserRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void AsaveTest(){
        User user = new User();
        user.setPassword("123");
        user.setEmail("aaschlote@gmail.com");
        user.setName("Alex");

        User createdUser = userRepository.save(user);
        assertThat(createdUser.getId()).isEqualTo(1L);
    }

    @Test
    public void AupdateTest(){
        User user = new User();
        user.setId(1L);
        user.setPassword("123");
        user.setEmail("aaschlote@gmail.com");
        user.setName("Alex Schlote");

        User updatedUser = userRepository.save(user);
        assertThat(updatedUser.getName()).isEqualTo("Alex Schlote");
    }

    @Test
    public void login(){
        Optional<User> result = userRepository.login("aaschlote@gmail.com","123");
        User loggedUser = result.get();
        assertThat(loggedUser.getId()).isEqualTo(1L);
    }

}
