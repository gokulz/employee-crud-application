package com.gokulcodes.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gokulcodes.entity.Employees;


public interface EmployeesRepository extends  JpaRepository<Employees,Integer>{

    
} 
    

