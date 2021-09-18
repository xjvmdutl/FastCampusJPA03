package com.fastcampus.jpa.FastCampusJPA03.repository;

import com.fastcampus.jpa.FastCampusJPA03.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserHistoryRepositoryTest {
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userHistoryTest(){


        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");
        userRepository.save(user);
        user.setName("martin-new-new");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}
