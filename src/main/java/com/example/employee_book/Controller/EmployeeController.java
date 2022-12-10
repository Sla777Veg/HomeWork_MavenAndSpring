package com.example.employee_book.Controller;

import com.example.employee_book.model.Employee;

import com.example.employee_book.record.EmployeeRequest;
import com.example.employee_book.service.EmplServ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

//HTTP Met: GET - Получение ресурса или набора ресурсов
//POST - Создание ресурса
//PUT - Модификация ресурса
//PATCH - частичная модификация
//DELETE - удаление
@RestController

public class EmployeeController {

    private final EmplServ emplServ;

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.emplServ.getAllEmployees();
    }

    public EmployeeController(EmplServ emplServ) {
        this.emplServ = emplServ;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.emplServ.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.emplServ.getSalarySum();
    }

    @GetMapping("/employees/salary/min")
    public Employee getEmplMinSalary() {
        return this.emplServ.getEmplMinSalary();
    }

    @GetMapping("/employees/salary/max")
    public Employee getEmplMaxSalary() {
        return this.emplServ.getEmplMaxSalary();
    }

    @GetMapping("/employees/high-salary")
    public List<Employee> getEmployeesWithSalaryMoreThatAverage() {
        return this.emplServ.getEmployeesWithSalaryMoreThatAverage();
    }
}

