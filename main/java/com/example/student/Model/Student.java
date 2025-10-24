package com.example.student.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "Email")
    private String email;

}
