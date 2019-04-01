package com.example.experiment_03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Address address;
    @Column(columnDefinition = "timestamp not null default current_timestamp",
            updatable = false, insertable = false)
    private LocalDateTime insertTime;

    public UserAddress(User user, Address address) {
        this.user = user;
        this.address = address;
    }
}
