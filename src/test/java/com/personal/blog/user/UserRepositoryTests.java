package com.personal.blog.user;
import com.personal.blog.entities.UserEntity;
import com.personal.blog.repositories.UsersRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Order(1)
    void can_create_users() {
        usersRepository.save(
                UserEntity.builder()
                        .userName("anshul")
                        .email("anshul@email.com")
                        .build()
        );
    }

}
