package com.example.practisewithoutsequrity.model;

import com.example.practisewithoutsequrity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    String name;
    String telephone;
    String email;
    String position;
    String password;
    String login;


    public User toUser(PasswordEncoder pasEnc){
        User user=new User();

        user.setUsername(name);
        user.setPhone(telephone);
        user.setEmail(email);
        user.setPosition(position);
        user.setPassword(pasEnc.encode(password));
        //user.setLogin(login);
        user.setRole("ROLE_USER");

        return user;
    }

}
