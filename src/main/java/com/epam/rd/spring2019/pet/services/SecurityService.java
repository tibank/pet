package com.epam.rd.spring2019.pet.services;

import com.epam.rd.spring2019.pet.models.User;


public interface SecurityService {

    boolean isCorrectPassword(User user, String password);
}
