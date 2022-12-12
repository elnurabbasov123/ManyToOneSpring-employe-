package com.orient.employe.service.impl;

import com.orient.employe.dto.EmployeDTO;
import com.orient.employe.entity.Department;
import com.orient.employe.entity.Employe;
import com.orient.employe.repository.DepartmentRepository;
import com.orient.employe.repository.EmployeRepository;
import com.orient.employe.service.inter.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void updateEmp(Employe employe, Long id, String depName) {
        List<Department> departments=departmentRepository.findAll();
        Long dId=null;

        for(Department department:departments){
            if(department.getDepartmentName().equals(depName)){
                dId=department.getId();
            }
        }
        Department  newDep=departmentRepository.findById(dId).get();


        Employe oldEmp=employeRepository.findById(id).get();


        oldEmp.setName(employe.getName());
        oldEmp.setUserName(employe.getUserName());
        oldEmp.setPassword(employe.getPassword());
        oldEmp.setRole(employe.getRole());
        oldEmp.setDepartment(newDep);


        employeRepository.save(oldEmp);

    }

    @Override
    public void addEmp(Employe employe,String depName) {
        List<Department> departments=departmentRepository.findAll();
        Long id=null;

        for(Department department:departments){
            if(department.getDepartmentName().equals(depName)){
                id=department.getId();
            }
        }
        Department dep=departmentRepository.findById(id).get();
        employe.setDepartment(dep);

        employeRepository.save(employe);
    }

    @Override
    public List<Employe> findAllEmp() {
        return employeRepository.findAll();
    }

    @Override
    public Employe findByIdEmp(Long id) {
        return employeRepository.findById(id).get();
    }


    @Override
    public void deleteEmp(Long id) {
        Employe employe=employeRepository.findById(id).get();

        employeRepository.delete(employe);
    }
}
