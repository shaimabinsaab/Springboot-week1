package com.example.demo.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Matcher;

@Data
@AllArgsConstructor
public class Employee {
@NotEmpty
@Min(2)
    private String id;
    @NotNull
    @Max(25)
    private String name;
    @NotNull
    @Pattern(regexp = "\b d+\b",message = "age must be older than 25")
    @Min(25)
    private int age;
    @NotNull
    @Pattern(regexp = "\\b(supervisor|coordinator)\\b",message = "roll must be supervisor or coordinator")
    private String position;
    @AssertFalse
    private boolean onleave;
    @NotNull
    @Pattern(regexp = "\b d+\b",message = "emplyee must provide employment year")
    @Past
    private int employmentYear;
    @NotNull
    @Pattern(regexp = "\b d+\b", message = "you have to be inserting valid number")
    private int annualLeave;


}
