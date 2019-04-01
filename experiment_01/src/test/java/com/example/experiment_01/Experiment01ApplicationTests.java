package com.example.experiment_01;

import com.example.experiment_01.respository.ElectiveRepository;
import com.example.experiment_01.respository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Experiment01ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ElectiveRepository electiveRepository;

    @Test
    public void contextLoads() {
        userRepository.addUserAddress();
    }

    @Test
    public void TestElective() {
        electiveRepository.addElective();
    }
}