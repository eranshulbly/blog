package com.personal.blog.DTO;

import lombok.Data;

public class UserDTO {

    @Data
    public static class CreateUserRequest{
        private String username;
        private String email;
        private String password;
        private String bio;
    }

    @Data
    public static class LoginUserRequest{
        private String username;
        private String password;
    }

    @Data
    public static class LoginUserResponse{
        private String id;
        private String username;
        private String email;
        private String bio;
        private String token;
    }

    @Data
    public static class GetUserResponse{
        private String id;
        private String username;
        private String bio;
    }
}
