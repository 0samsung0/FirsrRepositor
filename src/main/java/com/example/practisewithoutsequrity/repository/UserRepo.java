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


//    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.name = :username")
//    boolean existsByUsername(@Param("username") String username);

    Optional<User> findById(String name);

    List<User> findAllBy();

    User findByUsername(String username);


}