package com.employes.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_project")
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    
    @Column(unique = true)

    private String nik;
    
    private String name;


    @Column(length = 500)
    private String address;
    private Date date;
    private String country;

    private String gender;

    public Employees() {
    }

    public Employees( String nik, String name, String gender, String address, Date date,
            String country) {
        this.nik = nik;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.date = date;
        this.country = country;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getNik() {
    return nik;
    }

    public void setNik(String nik) {
    this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}


