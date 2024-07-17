package com.example.practisewithoutsequrity.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

    private Long id;
    private Double statusTime;
    private Double statusTask;
    



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
