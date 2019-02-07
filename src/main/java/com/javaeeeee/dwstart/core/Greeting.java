package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
    @JsonProperty   //serialize/deserialize
    private String greeting;

    public Greeting() {
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

}
