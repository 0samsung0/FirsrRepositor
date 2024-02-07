package com.example.practisewithoutsequrity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name = "position")
    private String position;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;



    public User() {}

    public User(String n, String ph, String e, String pos, String p, String l){
        this.name=n;
        this.phone=ph;
        this.email=e;
        this.position=pos;
        this.password=p;
        this.login=l;
        this.role=new Role();
    }

    public User(String name, String pass){
        this.name=name;
        this.password=pass;
    }

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    //@ManyToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(
            name = "user_auto",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "auto_id")
    )
    private List<Automobile> auto;

    @ManyToMany
    @JoinTable(
            name = "ride_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "drive_id")
    )
    private List<Drive> drive;

    public String getRole(){return role.toString();}
}
