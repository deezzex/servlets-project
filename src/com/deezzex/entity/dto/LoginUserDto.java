/**
 * @author deezzex <3
 */


package com.deezzex.entity.dto;

import com.deezzex.entity.enums.Gender;
import com.deezzex.entity.enums.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class LoginUserDto {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    LocalDate birthday;
    Role role;
    Gender gender;
    String password;
}
