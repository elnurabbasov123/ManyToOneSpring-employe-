package com.orient.employe.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Entity(name = "department")
@Data
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentManager;

//    @OneToMany
//    @JoinColumn(name = "departmentId")
//    private List<Employe> employes=new ArrayList<>();

}
