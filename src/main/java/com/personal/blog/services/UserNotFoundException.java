package com.personal.blog.services;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("No such username present");
    }
}
