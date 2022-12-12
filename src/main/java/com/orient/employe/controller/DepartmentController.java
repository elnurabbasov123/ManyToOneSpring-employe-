package com.orient.employe.controller;

import com.orient.employe.entity.Department;
import com.orient.employe.service.inter.DepartmentService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/get")
    public List<Department> findAllDep(){
        return departmentService.findAllDep();
    }

    @GetMapping("/get/{id}")
    public Department findById(@PathVariable Long id){
        return departmentService.findByIdDep(id);
    }

    @PostMapping("/create")
    public void addDep(@RequestBody Department department){
        departmentService.addDep(department);
    }

    @PutMapping("/update")
    public void updateDep(@PathVariable Long id,@RequestBody Department department){
        departmentService.updateDep(department,id);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable Long id){
        departmentService.deleteDep(id);
    }
}
