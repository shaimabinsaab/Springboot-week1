package com.example.springboot_project1.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "user id must not be empty")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int id;
    @NotEmpty(message = "name must be provided")
    @Size(min = 5,message = "name must be more than 5 character")
    private String username;
    @NotEmpty(message = "Password must be provided")
    @Pattern(regexp = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{6,}$",message = "please provide valid Password, Password must be atleast 6 digit and must contain two uppercase and two number and at least one special character  ")
    private String password;
    @Email(message = "enter proper email")
    private String email;

    @Pattern(regexp = "\\b(Admin|Customer)\\b",message = "roll must be Admin or Customer")
    @NotEmpty(message = "role must be provided")
    private String role;
    @NotNull(message = "balance must be provided")
    @Positive(message = "balance must be positive")
    private int balance;
}
