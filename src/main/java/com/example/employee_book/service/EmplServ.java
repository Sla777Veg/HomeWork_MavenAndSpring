package com.example.employee_book.service;

import com.example.employee_book.exception.InvalidEmployeeRequestException;
import org.springframework.util.StringUtils;

import com.example.employee_book.exception.EmployeeNotFoundException;
import com.example.employee_book.model.Employee;

import com.example.employee_book.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmplServ {

    private final Map<Integer, Employee> emoloyees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.emoloyees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (StringUtils.isEmpty(employeeRequest.getFirstName()) ||
                StringUtils.isEmpty(employeeRequest.getLastName())) {
            throw new InvalidEmployeeRequestException();
        }
        Employee employee = new Employee(StringUtils.capitalize(employeeRequest.getFirstName()),
                StringUtils.capitalize(employeeRequest.getLastName()),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.emoloyees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return emoloyees.values().stream().mapToInt(Employee::getSalary)
                .sum();
    }

    public Employee getEmplMinSalary() {
        return emoloyees.values().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmplMaxSalary() {
        return emoloyees.values().stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getEmployeesWithSalaryMoreThatAverage() {
        Double averageSalary = getAverageSalary();
        if (averageSalary == null) {
            return Collections.emptyList();
        }
        return emoloyees.values().stream().
                filter(e -> e.getSalary() > averageSalary).collect(Collectors.toList());
    }

    private Double  getAverageSalary() {
        return emoloyees.values().stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
    }

}
