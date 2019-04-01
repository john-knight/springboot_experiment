package com.example.experiment_03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;

    @OneToMany(mappedBy = "address")
    private List<UserAddress> userAddresses;

    public Address(String detail) {
        this.detail = detail;
    }
}
