package com.example.testdemo.dao;

import com.example.testdemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class EmployeeDao {
  List<Employee> employees = new CopyOnWriteArrayList<Employee>();
  public List<Employee> getEmployees() {
    return employees;
  }
  public Employee saveEmployee(Employee employee) {
    employees.add(employee);
    return employee;
  }

  public Employee deleteEmployee(Integer employeeId) {
    Employee response = null;
    for (Employee employee: employees) {
      if (employee.getId().equals(employeeId)) {
        employees.remove(employee);
        response = employee;
      }
    }
    return response;
  }

  public Employee updateEmployee(Integer employeeId, Employee updateEmployee) {
    Employee response = null;
    for (Employee employee : employees) {
      if (employee.getId().equals(employeeId)) {
        employees.remove(employee);
        response = updateEmployee(employee, updateEmployee);
        employees.add(response);
      }
    }
    return response;
  }

  private Employee updateEmployee(Employee employee, Employee updateEmployee) {
    if(updateEmployee.getId() >= 0) {
      employee.setId(updateEmployee.getId());
    }
    if(updateEmployee.getName() != null && !"".equalsIgnoreCase(updateEmployee.getName().trim())) {
      employee.setName(updateEmployee.getName());
    }
    if(updateEmployee.getMessage() != null && !"".equalsIgnoreCase(updateEmployee.getMessage().trim())) {
      employee.setMessage(updateEmployee.getMessage());
    }
    return employee;
  }
}
