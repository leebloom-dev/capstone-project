package org.launchcode.recipes.service;

import org.launchcode.recipes.models.User;
import org.launchcode.recipes.web.dto.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto registrationDto);

}
