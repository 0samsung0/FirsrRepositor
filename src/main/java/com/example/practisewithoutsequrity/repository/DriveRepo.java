package com.example.practisewithoutsequrity.repository;

import com.example.practisewithoutsequrity.entity.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveRepo extends JpaRepository<Drive, Integer> {


}
