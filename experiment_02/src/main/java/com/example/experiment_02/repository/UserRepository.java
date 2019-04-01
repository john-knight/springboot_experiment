package com.example.experiment_02.repository;

import com.example.experiment_02.entity.Address;
import com.example.experiment_02.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Slf4j
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     * @param user
     * @return
     */
    public User addUser(User user) {
        em.persist(user);    //对象转为持久化状态
        em.refresh(user);    //强制数据库数据，同步到受管对象
        return user;
    }

    /**
     * 添加地址，并指定地址对应的用户
     * @param address
     * @param uid
     * @return
     */
    public Address addAddress(Address address, int uid) {
        User user = em.find(User.class, uid);    //基于实体类型与对象标识查询，返回受管对象
        address.setUser(user);
        em.persist(address);      //对象转为持久化状态
        return address;
    }

    /**
     * 更新指定ID用户的姓名 ----- 使用find()方法实现更新
     * @param uid
     * @param newName
     * @return
     */
    public User updateUser(int uid, String newName) {
        User user = em.find(User.class, uid);    //查询，返回受管对象
        user.setName(newName);
        return user;
    }

    /**
     * 更新指定地址为指定用户 ----- 使用merge()方法实现更新
     * @param aid
     * @param uid
     * @return
     */
    public Address updateAddress(int aid, int uid) {
        Address address1 = new Address();
        address1.setId(aid);   //有主键即判断为脱管对象
        Address address2 =  em.merge(address1);  //基于脱管对象的主键，从数据库查询数据，并封装到受管新对象,merge()方法将同步更新对象的全部属性!!!
        em.refresh(address2);                    //从数据库更新数据至受管对象，覆盖空数据
        User user = em.find(User.class, uid);    //根据uid查找用户
        address2.setUser(user);                  //merge()返回的新对象为受管状态
        return address2;
    }

    /**
     * 返回指定用户的全部地址，没有返回空集合，而非null
     * @param uid
     * @return
     */
    public List<Address> listAddresses(int uid) {
        User user = em.find(User.class, uid);
        if (user != null) {
            List<Address> addressList = new ArrayList<>();
            user.getAddresses().forEach(a -> addressList.add(a));
            return addressList;
        }
        log.debug("未找到指定用户，返回空集合！！！");
        return List.of();
    }

    public void removeAddress(int aid) {
        Address address = em.find(Address.class, aid);
        if (address != null) {
            em.remove(address);
        }
    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     * @param uid
     */
    public void remaveUser(int uid) {
        User user = em.find(User.class, uid);
        if (user != null) {
            em.remove(user);      //在one端声明级联删除 ： cascade = CascadeType.REMOVE
        }
    }
}   