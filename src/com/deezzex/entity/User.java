/**
 * @author deezzex <3
 */


package com.deezzex.entity;

import com.deezzex.entity.enums.Gender;
import com.deezzex.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private Role role;
    private Gender gender;
    private String password;
}
