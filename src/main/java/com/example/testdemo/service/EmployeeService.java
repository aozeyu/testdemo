package com.example.testdemo.service;

import com.example.testdemo.dao.EmployeeDao;
import com.example.testdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeDao employeeDao;

  public List<Employee> getEmployees() {
    return employeeDao.getEmployees();
  }

  public Employee saveEmployee(Employee employee) {
    return employeeDao.saveEmployee(employee);
  }

  public Employee deleteEmployee(Integer employeeId) {
    return employeeDao.deleteEmployee(employeeId);
  }

  public Employee updateEmployee(Integer employeeId, Employee employee) {
    return employeeDao.updateEmployee(employeeId, employee);
  }

}
