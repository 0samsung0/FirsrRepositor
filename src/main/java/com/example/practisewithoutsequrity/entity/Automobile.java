package com.example.practisewithoutsequrity.entity;


//@ToString
//@EqualsAndHashCode
//@Entity
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Automobile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Column(name = "brand")
//    private String brand;
//
//    @Column(name = "color")
//    private String color;
//
//    @Column(name = "count_place")
//    private Integer count_place;
//
////    @ManyToOne
////    @JoinColumn(name = "drive_id")
////    private Drive drive;
//
//    public Automobile(String brandd, String colorr, Integer count){
//        this.brand=brandd;
//        this.color=colorr;
//        this.count_place=count;
//    }
//}

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "count_place")
    private Integer countPlace;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_id", nullable = true)
    @JsonIgnore
    private Drive drive;
}