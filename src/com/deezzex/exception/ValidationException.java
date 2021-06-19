/**
 * @author deezzex <3
 */


package com.deezzex.exception;

import com.deezzex.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {
    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }

}
