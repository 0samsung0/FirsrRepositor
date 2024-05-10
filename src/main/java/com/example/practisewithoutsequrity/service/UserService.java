package com.example.practisewithoutsequrity.service;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService
        //implements UserDetailsService
{

    private UserRepo userRepository;


    @Autowired
    UserService(UserRepo UR){
        this.userRepository = UR;
    }


    UserService(){}

    public List<User> findByAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void SaveUser(User u){
        userRepository.save(u);
    }

   // public User findByLogin(String login) { return userRepository.findByLogin(login); }

    public User updateUser(int id , User u){

        User oldUser = userRepository.findById(id).get();

        oldUser.setPhone(u.getPhone());
        oldUser.setEmail(u.getEmail());
        oldUser.setUsername(u.getUsername());
        oldUser.setPosition(u.getPosition());

        return userRepository.save(oldUser);
    }

}

