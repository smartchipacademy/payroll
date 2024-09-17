package com.example.Super.Admin.Controller;

import com.example.Super.Admin.Service.EmployeeService;
import com.example.Super.Admin.dao.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Employee> getAllEmployees() {
       return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveOrUpdateEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
         Employee existingEmployee= employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setDateOfJoining(employee.getDateOfJoining());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setBaseSalary(employee.getBaseSalary());
            existingEmployee.setBonus(employee.getBonus());
            return employeeService.saveOrUpdateEmployee(existingEmployee);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
