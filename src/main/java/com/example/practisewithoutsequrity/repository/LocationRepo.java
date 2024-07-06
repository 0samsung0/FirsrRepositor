package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
    Optional<Location> findById(Integer location);
}
