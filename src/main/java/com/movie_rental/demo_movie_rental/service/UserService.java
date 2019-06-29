package com.movie_rental.demo_movie_rental.service;

import com.movie_rental.demo_movie_rental.domain.User;
import com.movie_rental.demo_movie_rental.exception.NotFoundException;
import com.movie_rental.demo_movie_rental.repository.UserRepository;
import com.movie_rental.demo_movie_rental.service.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setPassword(HashUtil.getSecureHash(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public int updatePassword(Long id, String password){
        return userRepository.updatePassword(id, HashUtil.getSecureHash(password));
    }

    public User login(String email, String password){
        Optional<User> result = userRepository.login(email,HashUtil.getSecureHash(password));
        return result.orElseThrow(() -> new NotFoundException("Wrong Email or Password"));
    }

    public User getById(Long id){
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException("There are not user with id " + id));
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
