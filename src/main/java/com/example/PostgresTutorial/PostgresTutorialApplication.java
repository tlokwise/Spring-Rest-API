package com.example.PostgresTutorial;

import com.example.PostgresTutorial.Entity.Users;
import com.example.PostgresTutorial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class PostgresTutorialApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostgresTutorialApplication.class, args);
	}
}
