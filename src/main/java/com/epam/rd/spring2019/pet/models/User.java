package com.epam.rd.spring2019.pet.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = -2536586016566056784L;

    private Long id;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDate birthDay;
    private String email;
    private String password;
    private LocalDate created;
    private boolean isAdmin;
    private boolean isBlocked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setId(Long id) {
            newUser.id = id;

            return this;
        }

        public Builder setFirstName(String firstName) {
            newUser.firstName = firstName;

            return this;
        }

        public Builder setLastName(String firstName) {
            newUser.lastName = firstName;

            return this;
        }

        public Builder setSex(String sex) {
            newUser.sex = sex;

            return this;
        }

        public Builder setBirthDay(LocalDate birthDay) {
            newUser.birthDay = birthDay;

            return this;
        }
        public Builder setEmail(String email) {
            newUser.email = email;

            return this;
        }

        public Builder setPassword(String pwd) {
            newUser.password = pwd;

            return this;
        }

        public Builder setCreated(LocalDate created) {
            newUser.created = created;

            return this;
        }

        public Builder setIsAdmin(boolean isAdmin) {
            newUser.isAdmin = isAdmin;

            return this;
        }

        public Builder setIsBlocked(boolean isBlocked) {
            newUser.isBlocked = isBlocked;

            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
