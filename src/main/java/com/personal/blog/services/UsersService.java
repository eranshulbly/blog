package com.personal.blog.services;

import com.personal.blog.DTO.UserDTO;
import com.personal.blog.entities.UserEntity;
import com.personal.blog.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper modelMapper;

    /*Signup User*/
    public UserDTO.LoginUserResponse signupUser(UserDTO.CreateUserRequest user) {
        UserEntity savedUser = usersRepository.save(modelMapper.map(user, UserEntity.class));
        UserDTO.LoginUserResponse response = modelMapper.map(savedUser, UserDTO.LoginUserResponse.class);
        response.setToken("token");
        return response;
    }

    /*Login User*/
    public UserDTO.LoginUserResponse loginUser(UserDTO.LoginUserRequest userRequest) {
        UserEntity user = usersRepository.findByUserName(userRequest.getUsername()).orElseThrow(
                () -> new UserNotFoundException(userRequest.getUsername())
        );
        if(user.getPassword().equals(userRequest.getPassword())){
            UserDTO.LoginUserResponse response = modelMapper.map(user,UserDTO.LoginUserResponse.class);
            response.setToken("token");
            return response;
        }else{
            throw new UserAuthenticationException();
        }
    }

    /*find user by username*/
    public UserDTO.GetUserResponse findUserByUsername(String username){
        UserEntity user = usersRepository.findByUserName(username).orElseThrow(
                () -> new UserNotFoundException(username)
        );
        return modelMapper.map(user, UserDTO.GetUserResponse.class);
    }

    private static class UserAuthenticationException extends SecurityException {
        private UserAuthenticationException(){
            super("User is not authorized");
        }
    }
}
