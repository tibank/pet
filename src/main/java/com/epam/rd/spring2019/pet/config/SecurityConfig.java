package com.epam.rd.spring2019.pet.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SecurityConfig {

    private Set<String> protectedUrLsForGuest = new HashSet<>();
    private Set<String> protectedUrLsForUser = new HashSet<>();

    public SecurityConfig() {
        protectedUrLsForUser.add("/admin");
        protectedUrLsForUser.add("/addproduct.jsp");
        protectedUrLsForUser.add("/addproduct");
        protectedUrLsForUser.add("/products.jsp");

        protectedUrLsForGuest.addAll(protectedUrLsForUser);
        protectedUrLsForGuest.add("/profile.jsp");
        protectedUrLsForGuest.add("/profile");
        protectedUrLsForGuest.add("/createorder");
        protectedUrLsForGuest.add("/order");
        protectedUrLsForGuest.add("/createorder.jsp");
    }

    public Set<String> getProtectedURLsForGuest() {
        return Collections.unmodifiableSet(protectedUrLsForGuest);
    }

    public Set<String> getProtectedURLsForUser() {
        return Collections.unmodifiableSet(protectedUrLsForUser);
    }
}
