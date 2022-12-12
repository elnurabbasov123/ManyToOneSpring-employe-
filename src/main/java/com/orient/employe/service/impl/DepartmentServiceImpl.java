package com.orient.employe.service.impl;

import com.orient.employe.entity.Department;
import com.orient.employe.repository.DepartmentRepository;
import com.orient.employe.service.inter.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void addDep(Department department) {

        departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDep() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findByIdDep(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void updateDep(Department department,Long id) {

        Department oldDep=departmentRepository.findById(id).get();

        oldDep.setDepartmentName(department.getDepartmentName());
        oldDep.setId(department.getId());
        oldDep.setDepartmentManager(department.getDepartmentManager());

        departmentRepository.save(oldDep);
    }

    @Override
    public void deleteDep(Long id) {

        Department dep=departmentRepository.findById(id).get();
        departmentRepository.delete(dep);
    }
}
