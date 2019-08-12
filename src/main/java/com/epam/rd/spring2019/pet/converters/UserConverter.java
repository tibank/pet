package com.epam.rd.spring2019.pet.converters;

import com.epam.rd.spring2019.pet.models.User;
import com.epam.rd.spring2019.pet.web.dtos.UserCreateDto;
import com.epam.rd.spring2019.pet.web.dtos.UserViewDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserConverter {

    public UserViewDto asUserDto(User user) {
        UserViewDto dto = new UserViewDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setSex(user.getSex());
        dto.setEmail(user.getEmail());
        dto.setBirthDay(user.getBirthDay());
        dto.setBlocked(user.isBlocked());
        dto.setAdmin(user.isAdmin());
        dto.setCreated(user.getCreated());

        return dto;
    }

    public User asUser(UserCreateDto createDto) {
        User user = new User();

        user.setFirstName(createDto.getFirstName());
        user.setLastName(createDto.getLastName());
        user.setSex(createDto.getSex());
        user.setBirthDay(LocalDate.parse(createDto.getBirthDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        user.setEmail(createDto.getEmail());
        user.setPassword(createDto.getPassword());
        return user;
    }
}
