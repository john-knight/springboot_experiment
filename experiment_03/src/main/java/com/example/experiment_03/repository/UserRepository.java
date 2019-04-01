package com.example.experiment_03.repository;

import com.example.experiment_03.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //在UserRepository接口中，声明基ID查询user对象的方法
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findByUserID(@Param("id") int id);
}
