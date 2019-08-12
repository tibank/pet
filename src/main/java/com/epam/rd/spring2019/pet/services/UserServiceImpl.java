package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.converters.UserConverter;
import com.epam.rd.spring2019.pet.daos.UserDao;
import com.epam.rd.spring2019.pet.daos.UserDaoImpl;
import com.epam.rd.spring2019.pet.exceptions.ApplicationException;
import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.models.User;
import com.epam.rd.spring2019.pet.validators.UserValidator;
import com.epam.rd.spring2019.pet.validators.UserValidatorImpl;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import javax.naming.NamingException;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {

    private UserDao UserDao = new UserDaoImpl();
    private UserValidator userValidator = new UserValidatorImpl();
    private UserConverter UserConverter = new UserConverter();
    private SecurityService securityService = new SecurityServiceImpl();

    @Override
    public UserViewDto login(String email, String password) throws SQLException, ApplicationException, NamingException {

        userValidator.validateUserCredentials(email, password);

        User user = UserDao.getUserByEmail(email);

        if (!securityService.isCorrectPassword(user, password)) {
            throw new ValidationException("Wrong password");
        }
        return UserConverter.asUserDto(user);
    }

    @Override
    public UserViewDto registerUser(UserCreateDto createDto) throws SQLException, NamingException {
        try {
            userValidator.validateNewUser(createDto);
        } catch (ValidationException ex) {
            throw ex;
        }
        User user = UserConverter.asUser(createDto);
        user = UserDao.addUser(user);

        return UserConverter.asUserDto(user);
    }

    @Override
    public UserViewDto updateUser(UserCreateDto createDto) throws SQLException, NamingException, ValidationException {
        try {
            userValidator.validateNewUser(createDto);
        } catch (ValidationException ex) {
            throw ex;
        }
        User user = UserConverter.asUser(createDto);
        user = UserDao.updateUser(user);


        return UserConverter.asUserDto(user);
    }
}
