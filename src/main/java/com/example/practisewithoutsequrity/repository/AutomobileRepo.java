package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutomobileRepo extends JpaRepository<Automobile, Integer> {
    Optional<Automobile> findById(Integer id);

    Optional<Automobile> findByColor(String color);
    Optional<Automobile> findByUser(String user);
}
