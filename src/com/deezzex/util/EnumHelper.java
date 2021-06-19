/**
 * @author deezzex <3
 */


package com.deezzex.util;

import com.deezzex.entity.enums.Gender;
import com.deezzex.entity.enums.Role;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class EnumHelper {

    public static List<String> roles(){
        var values = Role.values();
        var roles = new ArrayList<String>();
        for (Role value : values) {
            roles.add(value.name());
        }
        return roles;
    }

    public static List<String> genders(){
        var values = Gender.values();
        var genders = new ArrayList<String>();
        for (Gender value : values) {
            genders.add(value.name());
        }
        return genders;
    }
}
