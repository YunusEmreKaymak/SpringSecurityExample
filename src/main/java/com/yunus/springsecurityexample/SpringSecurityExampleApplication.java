package com.yunus.springsecurityexample;

import com.yunus.springsecurityexample.model.Product;
import com.yunus.springsecurityexample.model.Role;
import com.yunus.springsecurityexample.model.User;
import com.yunus.springsecurityexample.repository.ProductRepository;
import com.yunus.springsecurityexample.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Set;

@SpringBootApplication
public class SpringSecurityExampleApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringSecurityExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepo, ProductRepository productRepo) {
        return args -> {
            userRepo.save(new User("user1","useraccount1","password1",true,true,true,true, Set.of(Role.ROLE_USER)));
            userRepo.save(new User("user2","useraccount2","password2",true,true,true,true, Set.of(Role.ROLE_DEV)));
            productRepo.save(new Product("product1", 3.2,"url1",4));
            productRepo.save(new Product("product2", 3.5,"url2",7));
        };
    }
}
