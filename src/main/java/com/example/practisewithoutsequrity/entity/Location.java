package com.example.practisewithoutsequrity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "drive")
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private Integer id;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "finish_location")
    private String finishLocation;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "finish_time")
    private LocalDate finishTime;

    @OneToOne(mappedBy = "location", orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_id", nullable = true)
    @JsonIgnore
    private Drive drive;
}




