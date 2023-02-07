package com.employes.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employes.models.entities.Employees;
import com.employes.models.repo.EmployeesRepo;

@Service
@Transactional
public class EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;

    public Employees save(Employees Employee) {
        return employeesRepo.save(Employee);
    }

    public Employees findOne(String nik) {
        Optional<Employees> employee = employeesRepo.findByNik(nik);
        if (!employee.isPresent()) {
            return null;
        } else {
            return employee.get();
        }
    }

    public Iterable<Employees> findAll() {
        return employeesRepo.findAll();

    }
    

    public void removeOne(String nik) {
        employeesRepo.deleteByNik(nik);
    }

    public List<Employees> findByNameLike(String name) {
        return employeesRepo.findByNameLike("%"+name+"%");
    }

    public List<Employees> findByNikLike(String nik) {
        return employeesRepo.findByNikLike("%"+nik+"%");
    }



    public List<Employees> searchEmployees(String name, String nik) {
        if (nik.equals("") && StringUtils.hasText(name)) {
            return employeesRepo.findByNameLike(name);
        } else if (StringUtils.hasText(nik) && name.equals("")) {
            return employeesRepo.findByNikLike(nik);
        } else {
            return employeesRepo.searchByNameAndNik(name, nik);
        }
    }

}
