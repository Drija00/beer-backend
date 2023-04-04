package com.example.beer.auth;

import com.example.beer.model.User;
import com.example.beer.model.UserDTO;
import com.example.beer.model.UserDTOEmailPass;
import com.example.beer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user-email-pass")
    @ResponseBody
    public Optional<UserDTO> getUserByEmailPass(
            @RequestParam String email,
            @RequestParam String password
    ) {
        System.out.println("XXXX");
        return userService.getUserByEmailPass(email, password);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user-email-pass2")
    @ResponseBody
    public Optional<String> getUserByEmailPass2(
            @RequestBody UserDTOEmailPass emailRequest
    ) {
        System.out.println("XXXX");
        return userService.getUserByEmailPass2(emailRequest.getEmail(),emailRequest.getPassword());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user-email")
    @ResponseBody
    public Optional<UserDTO> getUserByEmail(
            @RequestParam String email
    ) {
        return userService.getUserByEmail(email);
    }
}
