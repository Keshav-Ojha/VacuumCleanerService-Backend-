package com.examly.springapp.model;

import com.examly.springapp.entity.Users;

import lombok.*;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class JwtResponse {
    private Users users;
    private String token;
}
