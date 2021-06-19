/**
 * @author deezzex <3
 */


package com.deezzex.dao;

import com.deezzex.entity.User;
import com.deezzex.entity.enums.Gender;
import com.deezzex.entity.enums.Role;
import com.deezzex.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Long, User>{

    private static final UserDao INSTANCE = new UserDao();

    private static final String CREATE_SQL = """
            INSERT INTO servlets_project.users(userName, firstName, lastName, email, birthday, role, gender, password) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
            """;
    private static final String EXIST_SQL = """
            SELECT userName
            FROM servlets_project.users
            WHERE userName = ?
            """;
    private static final String LOGIN_SQL = """
            SELECT id, userName, firstName, lastName, email, birthday, role, gender, password
            FROM servlets_project.users
            WHERE userName = ? AND password = ?;
            """;


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @SneakyThrows
    @Override
    public User save(User entity) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getUserName());
            preparedStatement.setObject(2, entity.getFirstName());
            preparedStatement.setObject(3, entity.getLastName());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setObject(5, entity.getBirthday());
            preparedStatement.setObject(6, entity.getRole().name());
            preparedStatement.setObject(7, entity.getGender().name());
            preparedStatement.setObject(8, entity.getPassword());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getObject(1, Long.class));

            return entity;
        }

    }

    @SneakyThrows
    public List<String> findByUsername(String newUsername) {
        List<String> usernames = new ArrayList<>();

        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(EXIST_SQL)) {

            preparedStatement.setObject(1, newUsername);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                usernames.add(resultSet.getObject("userName", String.class));
            }
        }
        return usernames;
    }

    @SneakyThrows
    public Optional<User> findByUsernameAndPassword(String username, String password){
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(LOGIN_SQL);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();

            User user = null;

            if (resultSet.next()){
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Long.class))
                .userName(resultSet.getObject("userName", String.class))
                .firstName(resultSet.getObject("firstName", String.class))
                .lastName(resultSet.getObject("lastName", String.class))
                .email(resultSet.getObject("email", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .password(resultSet.getObject("password", String.class))
                .build();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }


}
