package com.personal.blog.repositories;

import com.personal.blog.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findById(int id);

    Optional<UserEntity> findByUserName(String userName);

}