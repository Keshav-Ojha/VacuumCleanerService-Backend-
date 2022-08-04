package com.examly.springapp.model;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoginForm {

    private String email;
    private String password;
}
