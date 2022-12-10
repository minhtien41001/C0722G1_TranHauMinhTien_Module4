package com.example.casestudy.dto;

import com.example.casestudy.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class CustomerDto implements Validator {

    private int id;

    @NotBlank(message = "Name cannot be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "name must be in correct format")
    private String name;

    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date dateOfBirth;

    private boolean gender;

    @NotBlank(message = "CMND cannot be left blank")
    @Pattern(regexp = "^\\d{9}$",message = "CMND must be in the correct format")
    private String idCard;

    @NotBlank(message = "Phone Number cannot be left blank ")
    @Pattern(regexp = "[0-9]{10}",message = "Phone Number must be in the correct format")
    private String phoneNumber;

    @NotBlank(message = "Email cannot be left blank ")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Email must be in the correct format")
    private String email;

    @NotBlank(message = "Address cannot be left blank ")
    @Pattern(regexp = "^[0-9]{1,3}[ ]\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")
    private String address;

    private CustomerType customerTypeId;

    public CustomerDto()     {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
    }
}
