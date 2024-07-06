package com.example.practisewithoutsequrity.service;


import com.example.practisewithoutsequrity.entity.Drive;
import com.example.practisewithoutsequrity.repository.DriveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveService {

    private DriveRepo driveRepo;

    @Autowired
    DriveService(DriveRepo driveRepo) {
        this.driveRepo = driveRepo;
    }

    public List<Drive> findByAll() {
        return driveRepo.findAll();
    }

    public void saveDrive(Drive drive){
        driveRepo.save(drive);
    }

}
