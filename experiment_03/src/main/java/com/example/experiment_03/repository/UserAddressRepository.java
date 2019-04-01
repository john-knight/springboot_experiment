package com.example.experiment_03.repository;

import com.example.experiment_03.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
    //在UserAddressRepository接口中，声明基于user name属性address detail属性，查询详细的useraddress对象的方法
    @Query("SELECT ua FROM UserAddress ua WHERE ua.user.name = :name AND ua.address.detail = :detail")
    UserAddress findByNameAndDetail(@Param("name") String name, @Param("detail") String detail);
}
