package com.example.pocjava;

import com.example.pocjava.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
@Slf4j
class PocJavaApplicationTests {

    @Test
    void pocSort() {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setUsername("bob");
        u.setPassword("1234");

        User u2 = new User();
        u2.setUsername("adam");
        u2.setPassword("4567");

        users.add(u);
        users.add(u2);
        log.info("Before Sort User: {}",users);

        // pass by reference
        users.sort(Comparator.comparing(User::getUsername));
        log.info("After Sort User: {}",users);
    }

}
