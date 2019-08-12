package com.epam.rd.spring2019.pet.validators;

import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;

public interface UserValidator {

    void validateUserCredentials(String email, String password) throws ValidationException;
    void validateNewUser(UserCreateDto createDto) throws ValidationException;

}
