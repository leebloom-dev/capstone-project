package org.launchcode.recipes.service;

import org.launchcode.recipes.models.User;
import org.launchcode.recipes.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
