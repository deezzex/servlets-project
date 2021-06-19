/**
 * @author deezzex <3
 */


package com.deezzex.validator;

import com.deezzex.entity.dto.CreateUserDto;
import com.deezzex.entity.enums.Gender;
import com.deezzex.util.ValidationHelper;
import com.deezzex.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{

    public static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();

        if (object.getUserName().isEmpty() ||
                object.getFirstName().isEmpty() ||
                object.getLastName().isEmpty() ||
                object.getEmail().isEmpty() ||
                object.getPassword().isEmpty()){
            validationResult.add(Error.of("invalid.rows", "Rows must be filled"));
        }
        if (!ValidationHelper.isUserExist(object.getUserName())){
            validationResult.add(Error.of("invalid.username", "Username already exist"));
        }
        if(!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.date" , "Birthday is invalid"));
        }
        var gender = Gender.find(object.getGender());
        if (object.getGender() == null || gender.isEmpty()){
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
