package com.gokulcodes.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.gokulcodes.entity.Employees;


public interface EmployeesSerivice {
    //to view all the employees
    List<Employees> findAll();

    //to find by id

    Employees findById(int id);

    //to update and create

    Employees save(Employees theEmployees);

    // to delete by id

    void deleteById(int id);

}
