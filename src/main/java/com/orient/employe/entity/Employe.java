package com.orient.employe.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "employe")
@Data
@RequiredArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
