package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepo extends JpaRepository<Automobile, Integer> {

    //List<Automobile> findAll();
}
