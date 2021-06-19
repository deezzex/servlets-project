/**
 * @author deezzex <3
 */


package com.deezzex.mapper;

import com.deezzex.entity.User;
import com.deezzex.entity.dto.LoginUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, LoginUserDto>{

    public static final UserMapper INSTANCE = new UserMapper();

    @Override
    public LoginUserDto mapFrom(User object) {
        return LoginUserDto.builder()
                .id(object.getId())
                .userName(object.getUserName())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .birthday(object.getBirthday())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
