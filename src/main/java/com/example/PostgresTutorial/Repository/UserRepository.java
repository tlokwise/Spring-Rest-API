package com.example.PostgresTutorial.Repository;

import com.example.PostgresTutorial.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<Users, String> {
    //Custom Queries
    Users findByUsername(String username);
    Users findByEmail(String email);

}
