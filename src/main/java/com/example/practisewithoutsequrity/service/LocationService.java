package com.example.practisewithoutsequrity.service;


import com.example.practisewithoutsequrity.entity.Location;
import com.example.practisewithoutsequrity.repository.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public void saveLocation(Location location){locationRepo.save(location);}

    public List<Location> findByAll(){
        return locationRepo.findAll();
    }


}
