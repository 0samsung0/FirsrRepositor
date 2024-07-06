package com.example.practisewithoutsequrity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Task")
@ToString
public class Task {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "lvl_important")
    private Integer lvl_important;
    @Column(name = "cost")
    private Integer cost;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_id", nullable = true)
    @JsonIgnore
    private Drive drive;
}
