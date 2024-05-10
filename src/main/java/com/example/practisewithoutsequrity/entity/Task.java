package com.example.practisewithoutsequrity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bio")
    private String Bio;
    @Column(name = "lvl_important")
    private Integer lvl_important;
    @Column(name = "cost")
    private Integer cost;


    @ManyToOne
    @JoinColumn(name = "task")
    private Drive drive;

}
