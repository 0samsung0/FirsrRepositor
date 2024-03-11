package com.example.practisewithoutsequrity.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Users")
@ToString
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


//    public User(String name, String pass){
//        this.name=name;
//        this.password=pass;
//    }

    @Enumerated(EnumType.STRING)
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

    public String getRole(){return role.getAuthority();}
    public Role isAdmin(){return role = Role.ADMIN;}
    public Role isUser(){return role = Role.USER;}
    public Role isSysAdmin(){return role = Role.SYSADMIN;}

    public void tooString(){
        System.out.println("id= " + id
                + " name= " + name
                + " phone= " + phone
                + " email=" + email
                + " position= " + position
                + " password= " + password
                + " login= " + login);
    }

}
