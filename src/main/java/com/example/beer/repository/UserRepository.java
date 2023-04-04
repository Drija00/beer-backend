package com.example.beer.repository;

import com.example.beer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    //@Query("SELECT u.id, u.firstname,u.lastname,u.password,u.role,u.email,t.token FROM User as u inner join Token as t where u.email = ?")
    Optional<User> findByEmail(String email);

    @Query("SELECT u.id, u.firstname,u.lastname,u.password,u.decriptedPass,u.role,u.email FROM User as u")
    List<User> getAll();
//    @Query("SELECT u.decriptedPass,u.email FROM User as u")
//    List<User> getAll();
    Optional<User> findByEmailAndDecriptedPass(String email, String password);

}
