package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")

    public ResponseEntity<Employee> savedata(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.savedata(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getalldata")

    public ResponseEntity<List<Employee>> getalldata() {
        return ResponseEntity.ok(employeeServiceImpl.getalldata());
    }

    @GetMapping("/getdatabyid/{empid}")

    public ResponseEntity<Optional<Employee>> getdatabyid(@PathVariable int empid) {
        return ResponseEntity.ok(employeeServiceImpl.getdatabyid(empid));
    }

    @PutMapping("/updatedatbyid/{empid}")

    public ResponseEntity<Employee> updatedata(@PathVariable int empid, @Valid @RequestBody Employee employee) {

        Employee employee1 = employeeServiceImpl.getdatabyid(empid).orElseThrow(() -> new RecordNotFoundException("Employee Id Does Not Exist.."));

        employee1.setEmpname(employee.getEmpname());
        employee1.setEmpsalary(employee.getEmpsalary());
        employee1.setEmpdob(employee.getEmpdob());
        employee1.setEmpemailid(employee.getEmpemailid());
        employee1.setEmppassword(employee.getEmppassword());
        employee1.setEmpaddress(employee.getEmpaddress());
        employee1.setEmpid(employee.getEmpid());

        return new ResponseEntity<>(employeeServiceImpl.updatedata(employee1), HttpStatus.CREATED);

    }

    @PatchMapping("/addressupdate/{empid}/{empaddress}")

    public ResponseEntity<Employee> partialupdate(@PathVariable int empid, @PathVariable String empaddress) {
        Employee employee1 = employeeServiceImpl.getdatabyid(empid).orElseThrow(() -> new RecordNotFoundException("Employee Id Does Not Exist.."));

        employee1.setEmpaddress(empaddress);

        return ResponseEntity.ok(employeeServiceImpl.partialupdate(employee1));
    }


    @DeleteMapping("/deletedatabyid/{empid}")

    public ResponseEntity<String> deletedatbyid(@PathVariable int empid) {
        employeeServiceImpl.deletedatabyid(empid);
        return ResponseEntity.ok("Data Deleted SuccssFullyy");
    }

    @DeleteMapping("/deleteall")

    public ResponseEntity<String> deletealldata() {
        employeeServiceImpl.deleteall();
        return ResponseEntity.ok("All Data Deleted..");
    }


}
