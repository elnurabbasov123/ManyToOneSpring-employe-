package com.orient.employe.service.inter;

import com.orient.employe.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    List<Department> findAllDep();
    Department findByIdDep(Long id);
    void addDep(Department department);
    void updateDep(Department department,Long id);
    void deleteDep(Long id);
}
