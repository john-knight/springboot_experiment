package com.example.experiment_03.repository;

import com.example.experiment_03.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    //在AddressRepository接口中，声明基于detail属性查询全部address对象的方法
    @Query("SELECT a FROM Address a WHERE a.detail = :detail")
    List<Address> findByDetail(@Param("detail") String detail);
}
