package com.example.practisewithoutsequrity.service;


import com.example.practisewithoutsequrity.entity.Automobile;
import com.example.practisewithoutsequrity.repository.AutomobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomobileService {

    private AutomobileRepo automobileRepo;

    @Autowired
    public AutomobileService(AutomobileRepo automobileRepos) {
        this.automobileRepo = automobileRepos;
    }


    public void save(Automobile automobile) {
        System.out.println("\nsave automobile before");
        automobileRepo.save(automobile);
        System.out.println("\nsave automobile after");
    }


    public List<Automobile> findByAll() {
        return automobileRepo.findAll();
    }
}
