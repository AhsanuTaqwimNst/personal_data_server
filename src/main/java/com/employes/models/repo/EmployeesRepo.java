package com.employes.models.repo;

import com.employes.models.entities.Employees;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeesRepo extends CrudRepository <Employees, Long>{


    @Query("SELECT v FROM Employees v WHERE v.name LIKE :name%")
    public List<Employees> findByNameLike(@Param("name") String name);


    @Query("SELECT v FROM Employees v WHERE v.nik LIKE :nik%")
    public List<Employees> findByNikLike(@Param("nik") String nik);

    @Query("SELECT v FROM Employees v WHERE v.name LIKE :name% AND v.nik LIKE :nik%")
    public List<Employees> searchByNameAndNik(@Param("name") String name,
    @Param("nik") String nik);


    public void deleteByNik(String nik);


    public Optional<Employees> findByNik(String nik);


}

