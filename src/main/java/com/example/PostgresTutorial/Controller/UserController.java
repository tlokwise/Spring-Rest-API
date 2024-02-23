package com.example.PostgresTutorial.Controller;

import com.example.PostgresTutorial.Entity.Users;
import com.example.PostgresTutorial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path ="/api/users")
public class UserController {
    UserRepository userRepository;
    @Autowired
    private void userRepository(UserRepository userRepository) {this.userRepository = userRepository;}

    @RequestMapping(path="/findall", method=RequestMethod.GET)
    public List getAllUsers(){
        return userRepository.findAll();
    }

    //find user by username as a parameter
    @RequestMapping(path="/find/{username}", method= RequestMethod.GET)
    public Users getUser(@PathVariable(name= "username") String username){
        return userRepository.findByUsername(username);
    }

    @RequestMapping(path ="/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users saveUser(@RequestBody Users userToSave){
        return userRepository.save(userToSave);
    }

    //modify existing data
    @RequestMapping(path = "/modify/{username}", method = RequestMethod.PUT)
    public Users modifyUser(@PathVariable(name = "username") String username){
        Users userToModify = userRepository.findByUsername(username);
        if(userToModify != null){
            userToModify.setFirstname("talent");
        }
        userRepository.save(userToModify);
        return userToModify;
    }

    //delete existing data

    @RequestMapping(path="/delete/{username}")
    public void deleteUsers(@PathVariable(name="username") String username){
        Users findUser = userRepository.findByUsername(username);
        if(findUser != null){
            userRepository.delete(findUser);
        }
    }
}































//