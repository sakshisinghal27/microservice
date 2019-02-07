package com.javaeeeee.dwstart.core;

import java.security.Principal;

public class User implements Principal {
    String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
