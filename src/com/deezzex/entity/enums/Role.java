/**
 * @author deezzex <3
 */


package com.deezzex.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    USER, ADMIN;

    public static Optional<Role> find(String role){
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
