package com.example.experiment_02;

import com.example.experiment_02.entity.Address;
import com.example.experiment_02.entity.User;
import com.example.experiment_02.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Experiment02ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_addUser() {
        User u1 = new User("zhanyeye");
        userRepository.addUser(u1);
        log.debug(u1.getInsertTime().toString());
    }
    @Test
    public void test_addAddress() {
        Address a1 = new Address("115");
        userRepository.addAddress(a1, 1);
    }

    @Test
    public void test_updateUser() {
        userRepository.updateUser(1, "xiaoming");
    }

    @Test
    public void test_updateAddress() {
        User u2 = new User("panghu");
        userRepository.addUser(u2);
        userRepository.updateAddress(1,2);
    }

    @Test
    public void test_listAddresses() {
        Address a2 = new Address("722");
        Address a3 = new Address("712");
        Address a4 = new Address("725");
        User u3 = new User("huahua");
        userRepository.addUser(u3);
        userRepository.addAddress(a2, 3);
        userRepository.addAddress(a3, 3);
        userRepository.addAddress(a4, 3);
        userRepository.listAddresses(3).forEach(a -> {log.debug(a.getDetail());});

    }

    @Test
    public void test_removeAddress() {
        userRepository.removeAddress(4);
    }

    @Test
    public void test_remaveUser() {
        userRepository.remaveUser(3);
    }

}
