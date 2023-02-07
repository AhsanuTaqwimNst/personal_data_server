package com.employes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employes.dto.SearchData;
import com.employes.models.entities.Employees;
import com.employes.services.EmployeesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService; 
   

    @PostMapping
    public Employees create(@RequestBody Employees employees) {
        return employeesService.save(employees);
    }

    @GetMapping("{nik}")
    public Employees findOne(@PathVariable("nik") String nik) {
        return employeesService.findOne(nik);
    }

    @PatchMapping
    public Employees update(@RequestBody Employees employees) {
        return employeesService.save(employees);
    }

    @DeleteMapping("{nik}")
    public void removeOne(@PathVariable("nik") String nik) {
        employeesService.removeOne(nik);
    }

    @GetMapping
    public Iterable<Employees> findAll() {
        return employeesService.findAll();

    }

    @PostMapping("/search")
    List<Employees> search(@RequestBody SearchData searchData) {
        return employeesService.searchEmployees(searchData.getSearchByName(),
                searchData.getSearchByNik());
    }
    
}
