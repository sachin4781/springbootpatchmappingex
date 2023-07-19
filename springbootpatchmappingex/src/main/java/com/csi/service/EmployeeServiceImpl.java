package com.csi.service;


import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee savedata(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public List<Employee> getalldata() {
        return employeeRepoImpl.findAll();
    }

    public Optional<Employee> getdatabyid(int empid) {
        return employeeRepoImpl.findById(empid);
    }

    public Employee updatedata(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public Employee partialupdate(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deletedatabyid(int empid) {
        employeeRepoImpl.deleteById(empid);
    }

    public void deleteall() {
        employeeRepoImpl.deleteAll();
    }
}
