package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByLogin(String login);

    Optional<User> findByUsername(String name);

    List<User> findAllBy();



}