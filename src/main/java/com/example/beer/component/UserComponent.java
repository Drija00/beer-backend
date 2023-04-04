package com.example.beer.component;

import com.example.beer.auth.AuthenticationRequest;
import com.example.beer.model.User;
import com.example.beer.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

//@Component
//@RequiredArgsConstructor
//public class UserComponent {
//    private final UserService userService;
//
//    @PostConstruct
//    public void init(){
//        System.out.println(userService.getUserByEmail("maja@gmail.com"));
//    }
//}
