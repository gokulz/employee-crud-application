package com.gokulcodes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gokulcodes.entity.Employees;
import com.gokulcodes.service.EmployeesSerivice;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    //define the field
    private EmployeesSerivice employeesSerivice;


    //define the constructor injection
    public EmployeesController(EmployeesSerivice theEmployeesSerivice) {
        this.employeesSerivice = theEmployeesSerivice;
    }

    @GetMapping("list")
    public String listEmployees(Model theModel){

        //get the employees from db
        List<Employees> theEmployees = employeesSerivice.findAll();

        //add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }
    @GetMapping("/showFormAdd")
    public String showFormForAdd(Model theModel){
        //create model attribut to bind the date

        Employees theEmployees = new Employees();

        theModel.addAttribute("employee", theEmployees);

        return "employees/employee-form";
    }
    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int id, Model theModel){
       
        //get the employee form from the service

        Employees theEmployees = employeesSerivice.findById(id);

        //set employee model

        theModel.addAttribute("employee", theEmployees);


        // return the form

        return "employees/employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employees theEmployees){
        //save the employee
        employeesSerivice.save(theEmployees);

        //use the redirect to prevent the duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){

        //delete the employee id
        employeesSerivice.deleteById(theId);


        //redirect to the employees list
        return "redirect:/employees/list";
    }
    
}
