package com.example.beer.token;

import com.example.beer.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    @Expose(serialize = true)
    @SerializedName("tokenType")
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    public Integer user_id;

}
