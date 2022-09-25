package com.personal.blog.entities;


import lombok.*;

import javax.persistence.Entity;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity{
    private String userName;
    private String email;
    private String bio;
    private String avatarLink;
    private String password;
}
