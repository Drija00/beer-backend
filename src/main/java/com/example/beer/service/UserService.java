package com.example.beer.service;

import com.example.beer.component.Mapper;
import com.example.beer.model.User;
import com.example.beer.model.UserDTO;
import com.example.beer.repository.UserRepository;
import com.example.beer.token.Token;
import com.example.beer.token.TokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final Mapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, TokenRepository tokenRepository, Mapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<UserDTO> getUserByEmailPass(String email, String password){
        System.out.println(email+"            "+password);
        String encrypt = passwordEncoder.encode(password);
        Optional<User> user = userRepository.findByEmailAndDecriptedPass(email, password);
        System.out.println(encrypt);
        List<Token> tokens =  tokenRepository.findAllValidTokenByUser(user.get().getId());
        user.get().setTokens(tokens);
        System.out.println(user.get());
        System.out.println(tokens);
        UserDTO userDTO = mapper.toDto(user.get());
        System.out.println(userDTO);
        return Optional.ofNullable(userDTO);
    }
    public Optional<String> getUserByEmailPass2(String email, String password){
        System.out.println(email+"            "+password);
        String encrypt = passwordEncoder.encode(password);
        Optional<User> user = userRepository.findByEmailAndDecriptedPass(email, password);
        System.out.println(encrypt);
        List<Token> tokens =  tokenRepository.findAllValidTokenByUser(user.get().getId());
        user.get().setTokens(tokens);
        System.out.println(user.get());
        System.out.println(tokens);
        UserDTO userDTO = mapper.toDto(user.get());
        System.out.println(userDTO);
        return Optional.ofNullable(user.get().getTokens().get(0).getToken());
    }

    public Optional<UserDTO> getUserByEmail(String email){
        System.out.println(email);
        Optional<User> user = userRepository.findByEmail(email);
        List<Token> tokens =  tokenRepository.findAllValidTokenByUser(user.get().getId());
        user.get().setTokens(tokens);
        System.out.println(user.get());
        System.out.println(tokens);
        UserDTO userDTO = mapper.toDto(user.get());
        System.out.println(userDTO);
        return Optional.ofNullable(userDTO);
    }

    public List<User> getAll(){
        List<User> user = userRepository.findAll();
        System.out.println(user);
        return user;
    }
}
