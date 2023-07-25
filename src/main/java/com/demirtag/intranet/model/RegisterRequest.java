package com.demirtag.intranet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private Role role;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String birthday;

    private String title;

    private String manager;

    private String team;

}
