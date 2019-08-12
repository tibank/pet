package com.epam.rd.spring2019.pet.web.dtos;


import java.io.Serializable;

public class UserCreateDto implements Serializable {

    private static final long serialVersionUID = -8228541599708955074L;

    private String firstName;
    private String lastName;
    private String sex;
    private String birthDay;
    private String email;
    private String password;

    public UserCreateDto(String firstName, String lastName, String sex, String birthDay, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCreateDto that = (UserCreateDto) o;

        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (!getSex().equals(that.getSex())) return false;
        if (!getBirthDay().equals(that.getBirthDay())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        return getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getSex().hashCode();
        result = 31 * result + getBirthDay().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
