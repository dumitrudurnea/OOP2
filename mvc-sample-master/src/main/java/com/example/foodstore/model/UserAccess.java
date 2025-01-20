package com.example.foodStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity
@Table(name="user_access")
public class UserAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "access_time")
    private LocalDateTime accessTime;
}
