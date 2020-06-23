package com.management.stock.api;

import com.management.stock.model.Employee;
import com.management.stock.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 *

 @RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.

 The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services. It's a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.


 An EmployeeRepository is injected by constructor into the controller.

 We have routes for each operations (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls). (NOTE: It’s useful to read each method and understand what they do.)

  *
 *
 * CrossOrigin:
 * RestController:
 * GetMapping:
 * PutMapping:
 * PostMapping:
 * DeleteMapping:
 * GetMapping:
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(){
       employeeService = new EmployeeService();
   }

    @GetMapping("/employers")
    public ArrayList<Employee> getEmployers(){
       return employeeService.findAllEmployers();
    }

    @GetMapping("/employers/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employers/{employeeId}")
    public void updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee updateEmployee){
       employeeService.updateEmployee(employeeId, updateEmployee);
    }

    @PostMapping("/employers")
    public void createEmployee(@RequestBody Employee e){
       employeeService.addNewEmployee(e.getName(),e.getLastName(),e.getDepartment());
    }
    @DeleteMapping("/employers/{id}")
    public void deleteEmployee(@PathVariable Long id){
       employeeService.deleteEmployeeById(id.intValue());
    }

}
