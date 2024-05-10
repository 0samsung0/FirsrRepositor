package com.example.practisewithoutsequrity.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "count_place")
    private Integer count_place;


    @ManyToMany(mappedBy = "auto")
    private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "drive_id")
    private Drive drive;

    public Automobile(String brandd, String colorr, Integer count){
        this.brand=brandd;
        this.color=colorr;
        this.count_place=count;
    }
}
