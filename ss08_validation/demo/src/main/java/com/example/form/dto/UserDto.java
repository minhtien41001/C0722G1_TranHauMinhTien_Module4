package com.example.form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


public class UserDto implements Validator {


    @NotBlank(message = "Name cannot be left blank!")
    @Size(min = 5,max = 45,message = "Names must be at least 5, up to 45 characters long!")
    private String firstName;

    @NotBlank(message = "Name cannot be left blank!")
    @Size(min = 5,max = 45,message = "Names must be at least 5, up to 45 characters long!")
    private String lastName;

    @NotBlank(message = "Phone number can not be left blank!")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",message = "Phone number consists of 10 digits if there is a 0 in the first. If you don't enter 0 then there are 9 numbers left.")
    private String phoneNumber;

    @NotBlank(message = "age cannot be left blank!")
    @Min(value = 18,message = "age must be greater than or equal to 18!")
    private String age;

    @NotBlank(message = "email cannot be left blank!")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",message = "Email must be valid")
    private String email;

    public UserDto() {
    }

    public UserDto( String firstName, String lastName, String phoneNumber, String age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
    }
}
