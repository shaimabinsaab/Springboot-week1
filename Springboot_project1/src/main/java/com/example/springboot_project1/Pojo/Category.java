package com.example.springboot_project1.Pojo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "id must be provided")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int id;
    @NotEmpty(message = "name must be provided")
    @Size(min = 3,message = "name must be more than 3 character")
    private String name;
}
