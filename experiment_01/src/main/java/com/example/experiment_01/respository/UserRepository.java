package com.example.experiment_01.respository;

import com.example.experiment_01.entity.Address;
import com.example.experiment_01.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;
    public void addUserAddress() {
        User user = new User("bo");
        em.persist(user);

        Address address1 = new Address("956");
        address1.setUser(user);
        em.persist(address1);

        Address address2 = new Address("925");
        address2.setUser(user);
        em.persist(address2);
    }
}
