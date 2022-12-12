package com.orient.employe.controller;

import com.orient.employe.dto.EmployeDTO;
import com.orient.employe.entity.Employe;
import com.orient.employe.service.inter.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    EmployeService employeService;

    @GetMapping("/get")
    public List<Employe> findAll(){
      return   employeService.findAllEmp();
    }

    @GetMapping("/get/{id}")
    public Employe findById(@PathVariable Long id){
        return employeService.findByIdEmp(id);
    }

    @PostMapping("/create/{depName}")
    public void createEmp(@RequestBody Employe employe,@PathVariable String depName){
        employeService.addEmp(employe,depName);
    }

    @PutMapping("/update/{id}/{newDepName}")
    public void updateEmp(@PathVariable Long id,@PathVariable String newDepName,@RequestBody Employe employe){
        employeService.updateEmp(employe,id,newDepName);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmp(@PathVariable Long id){
        employeService.deleteEmp(id);
    }

}
