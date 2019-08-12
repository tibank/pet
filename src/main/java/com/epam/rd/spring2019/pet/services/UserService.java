package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import javax.naming.NamingException;
import java.sql.SQLException;


public interface UserService {

    UserViewDto login(String email, String password) throws SQLException, NamingException;
    UserViewDto registerUser(UserCreateDto createDto)
            throws SQLException, NamingException, ValidationException;
    UserViewDto updateUser(UserCreateDto createDto)
            throws SQLException, NamingException, ValidationException;

}
