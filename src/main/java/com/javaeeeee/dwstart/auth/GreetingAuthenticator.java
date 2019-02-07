package com.javaeeeee.dwstart.auth;

import com.javaeeeee.dwstart.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class GreetingAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials)
            throws AuthenticationException {
        if ("gfy".equals(credentials.getPassword())) {
            return Optional.of(new User());
        } else {
            return Optional.empty();
        }
    }
}
