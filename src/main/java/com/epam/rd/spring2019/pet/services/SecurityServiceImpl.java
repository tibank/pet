package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.models.User;

public class SecurityServiceImpl implements SecurityService {

    @Override
    public boolean isCorrectPassword(User user, String password) {
        return user.getPassword().equals(password);
    }
}
