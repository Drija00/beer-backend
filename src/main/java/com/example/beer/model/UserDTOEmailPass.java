package com.example.beer.model;


import com.example.beer.token.Token;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class UserDTOEmailPass{
    private String email;
    private String password;
}
