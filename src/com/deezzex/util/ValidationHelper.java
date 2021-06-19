/**
 * @author deezzex <3
 */


package com.deezzex.util;

import com.deezzex.service.UserService;
import lombok.experimental.UtilityClass;


@UtilityClass
public class ValidationHelper {
    public static final UserService userService = UserService.getInstance();

    public boolean isUserExist(String newUsername) {
        return userService.usernames(newUsername).isEmpty();
    }
}
