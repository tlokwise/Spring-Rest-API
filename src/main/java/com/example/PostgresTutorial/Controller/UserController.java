package com.example.PostgresTutorial.Controller;

import com.example.PostgresTutorial.Entity.Users;
import com.example.PostgresTutorial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/users/")
public class UserController {
    UserRepository userRepository;
    @Autowired
    private void userRepository(UserRepository userRepository) {this.userRepository = userRepository;}

    @RequestMapping(path="findall", method=RequestMethod.GET)
    public List getAllUsers(){
        return userRepository.findAll();
    }

    //find user by username as a parameter
    @RequestMapping(path="{username}", method= RequestMethod.GET)
    public Users getUser(@PathVariable(name= "username") String username){
        return userRepository.findByUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users saveUser(@RequestBody Users userTotSave){
        return userRepository.save(userTotSave);
    }
}
