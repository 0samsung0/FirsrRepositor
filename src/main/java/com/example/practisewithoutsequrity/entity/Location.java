package com.example.practisewithoutsequrity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class Location {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "location_id")
    Integer id;
    @Column(name = "start_location")
    String start_location;
    @Column(name = "finish_location")
    String finish_location;
    @Column(name = "start_time")
    String start_time;
    @Column(name = "finish_time")
    String finish_time;


    @OneToOne(mappedBy = "location")
    Drive drive;

}
