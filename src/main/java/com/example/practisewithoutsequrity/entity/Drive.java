package com.example.practisewithoutsequrity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(exclude = "location")
@ToString
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "title")
    private String title;







    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drive", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drive", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Automobile> auto = new ArrayList<>();

    @OneToOne(optional = false, cascade=CascadeType.DETACH, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drive", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> task = new ArrayList<>();





    public Drive(){}

    public Drive(String status, String title){
        this.title = title;
        this.status = status;
    }

}