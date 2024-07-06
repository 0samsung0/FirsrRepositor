package com.example.practisewithoutsequrity.entity;

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
@Table(name="Userer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "password")
    private String password;

    @Column(name = "total_money")
    private Integer totalMoney;

    @Column(name = "role")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_id", nullable = true)
    @JsonIgnore
    private Drive drive;
}