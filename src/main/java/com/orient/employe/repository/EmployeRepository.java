package com.orient.employe.repository;

import com.orient.employe.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
     Employe findByUserName(String userName);
}
