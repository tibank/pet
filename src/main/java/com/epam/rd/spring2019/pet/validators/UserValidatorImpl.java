package com.epam.rd.spring2019.pet.validators;

import com.epam.rd.spring2019.pet.exceptions.ValidationException;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserValidatorImpl implements UserValidator {

    @Override
    public void validateUserCredentials(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            throw new ValidationException("Invalid credentials: e-mail or/and password is empty!");
        }
    }

    @Override
    public void validateNewUser(UserCreateDto createDto) {
        List<String> listError = new ArrayList<>();
        try {
            validateUserCredentials(createDto.getEmail(), createDto.getPassword());
        } catch (ValidationException ex) {
            listError.add(ex.getMessage());
        }

        if (createDto.getFirstName().isEmpty()) {
            listError.add("Invalid: first name is empty");
        }

        if (createDto.getLastName().isEmpty()) {
            listError.add("Invalid: last name is empty");
        }

        String sex = createDto.getSex();
        if (sex.isEmpty()) {
            listError.add("Invalid: sex is empty");
        } else if (!sex.equals("male") && !sex.equals("female")) {
            listError.add("Weird type of sex: must be male or female! There is a " + sex + "!");
        }

        String birthDay = createDto.getBirthDay();
        if (birthDay.isEmpty()) {
            listError.add("Invalid: BirthDay is empty");
        } else {
            try {
                LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (IllegalArgumentException e) {
                listError.add("Invalid: date of BirthDay is not a date");
            }
        }

        if (listError.size() > 0) {
            ValidationException ex = new ValidationException("Error validation!!!");
            ex.setErrList(listError);
            throw ex;
        }
    }

}
