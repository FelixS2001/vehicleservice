package com.vehicleservice.vehicleservice.models.database;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee", catalog = "vehicleservice")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeID;

    @Column(name = "employee_firstname", nullable = false)
    private String firstName;

    @Column(name = "employee_lastname", nullable = false)
    private String lastName;

    @Column(name = "social_insurance_number", nullable = false)
    private String socialInsuranceNumber;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_store_id", referencedColumnName = "store_id")
    private Store store;

    public Employee() {
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
