package org.exercises.api.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetails {

    private final int id;
    private final String username;
    private final String firstName ;
    private final String lastName ;
    private final String  email;
    private final String  password;
    private final String  phone;
    private final int  userStatus;

}
