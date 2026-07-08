package com.example.crudDTODemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "Name cannot be null/empty or blank !")
    @Size(min = 3, max = 50, message = "Name must be within 2 to 50 character long !")
    private String name;

    @NotBlank(message = "email cannot be blank !")
    @Email (message = "email must be valid !")
    private String email;

    @NotNull(message = "Age is required !")
    @Min(value = 18, message = "Age must be at least 18 years old !")
    private Integer age;

    @NotNull(message = "Roll No. is required")
    private Integer rollNo;

    @NotBlank(message = "subject cannot be blank")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
