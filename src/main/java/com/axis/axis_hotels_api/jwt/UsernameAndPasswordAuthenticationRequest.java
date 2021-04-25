package com.axis.axis_hotels_api.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//This class is the request DTO for User
@NoArgsConstructor
@Getter
@Setter
public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;
}
