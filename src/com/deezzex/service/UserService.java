/**
 * @author deezzex <3
 */


package com.deezzex.service;

import com.deezzex.dao.UserDao;
import com.deezzex.entity.dto.CreateUserDto;
import com.deezzex.entity.dto.LoginUserDto;
import com.deezzex.exception.ValidationException;
import com.deezzex.mapper.CreateUserMapper;
import com.deezzex.mapper.UserMapper;
import com.deezzex.validator.CreateUserValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    @SneakyThrows
    public Long create(CreateUserDto userDto){

        var validationResult = createUserValidator.isValid(userDto);

        if (!validationResult.isValid()){
            throw new ValidationException(validationResult.getErrors());
        }

        var user = createUserMapper.mapFrom(userDto);

        userDao.save(user);

        return user.getId();
    }

    public Optional<LoginUserDto> login(String userName, String password){
        return userDao.findByUsernameAndPassword(userName, password)
                .map(userMapper::mapFrom);
    }

    public List<String> usernames(String newUsername){
        return userDao.findByUsername(newUsername);
    }

    public String buildBirthday(String day, String month, String year) {
        return String.format("%s-%s-%s", year, month, day);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
