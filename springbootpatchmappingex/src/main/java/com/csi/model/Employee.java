package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue

    private int empid;

    @Size(min = 5, message = "Employee Name Should Be Atleast 5 Character..")
    private String empname;

    private String empaddress;

    private double empsalary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empdob;

    @Email(message = "Email Id Must Be Valid..")
    private String empemailid;

    @Size(min = 4, message = "Employee Password Should Be Atleast 4 Character..")
    private String emppassword;

}
