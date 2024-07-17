package com.example.practisewithoutsequrity.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
