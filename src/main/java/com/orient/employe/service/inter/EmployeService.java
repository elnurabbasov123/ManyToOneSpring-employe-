package com.orient.employe.service.inter;
import com.orient.employe.dto.EmployeDTO;
import com.orient.employe.entity.Employe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeService {
    List<Employe> findAllEmp();
    Employe findByIdEmp(Long id);
    void addEmp(Employe employe,String depName);
    void updateEmp(Employe employe, Long id, String depName);
    void deleteEmp(Long id);
}
