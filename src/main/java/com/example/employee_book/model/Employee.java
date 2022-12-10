package com.example.employee_book.model;

public class Employee {
    private static int counter;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int department;
    private int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Emploee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                '}';
    }
}


