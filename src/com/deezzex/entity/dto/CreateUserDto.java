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
public class CreateUserDto {
    String userName;
    String firstName;
    String lastName;
    String email;
    String birthday;
    String role;
    String gender;
    String password;
}
