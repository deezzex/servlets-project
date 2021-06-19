/**
 * @author deezzex <3
 */


package com.deezzex.mapper;

import com.deezzex.entity.User;
import com.deezzex.entity.dto.CreateUserDto;
import com.deezzex.entity.enums.Gender;
import com.deezzex.entity.enums.Role;
import com.deezzex.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User>{
    public static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .userName(object.getUserName())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .password(object.getPassword())
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
