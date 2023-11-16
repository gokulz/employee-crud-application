package com.gokulcodes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;

import com.gokulcodes.dao.EmployeesRepository;
import com.gokulcodes.entity.Employees;

@Service
public class EmployeesServiceImpl  implements EmployeesSerivice{
     
    //define the repository field
    private EmployeesRepository employeesRepository;

    //define the constructor
 //   @Autowired
    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }


    @Override
    public List<Employees> findAll() {
       
        return employeesRepository.findAll();
    }

    @Override
    public Employees findById(int id) {
        Optional<Employees> result = employeesRepository.findById(id);

        Employees theEmployees = null;

        if(result.isPresent()){
             theEmployees = result.get();
        } else{
            throw new RuntimeException("Do not find the id " + id);
        }
      
        return theEmployees;
    }

    @Override
    public Employees save(Employees theEmployees) {

      return employeesRepository.save(theEmployees);
    }
        @Override
    public void deleteById(int id) {
      employeesRepository.deleteById(id);
        
    }
    
}
