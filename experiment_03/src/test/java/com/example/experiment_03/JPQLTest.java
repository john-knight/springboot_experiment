package com.example.experiment_03;

import com.example.experiment_03.entity.Address;
import com.example.experiment_03.entity.User;
import com.example.experiment_03.entity.UserAddress;
import com.example.experiment_03.repository.AddressRepository;
import com.example.experiment_03.repository.UserAddressRepository;
import com.example.experiment_03.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class
JPQLTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void init() {
        User u1 = new User("zhanyeye");
        userRepository.save(u1);

        User u2 = new User("huahua");
        userRepository.save(u2);

        Address a1 = new Address("722");
        addressRepository.save(a1);

        Address a2 = new Address("724");
        addressRepository.save(a2);

        Address a3 = new Address("714");
        addressRepository.save(a3);

        UserAddress ua1 = new UserAddress(u1, a1);
        userAddressRepository.save(ua1);

        UserAddress ua2 = new UserAddress(u1, a2);
        userAddressRepository.save(ua2);

        UserAddress ua3 = new UserAddress(u2, a3);
        userAddressRepository.save(ua3);
    }

    @Test
    public void userRepTest() {
        User u = userRepository.findByUserID(1);
        log.debug(u.getName());
    }

    @Test
    public void addressRepTest() {
        addressRepository.findByDetail("722")
                .forEach(a -> {
                    log.debug("{}",a.getId());
                });
    }

    @Test
    public void userAdressRepTest() {
        UserAddress ua = userAddressRepository.findByNameAndDetail("huahua", "714");
        log.debug("插入时间：{}",ua.getInsertTime());
    }


}
