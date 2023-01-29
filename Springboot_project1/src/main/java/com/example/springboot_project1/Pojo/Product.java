package com.example.springboot_project1.Pojo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "user id must not be empty")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int id;
    @NotEmpty(message = "name must be provided")
    @Size(min = 3,message = "name must be more than 3 character")
    private String name;
    @NotNull(message = "price can not be null")
    @Positive
    private int price;
    @NotNull(message = "category ID can not be null")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int categoryID;
}
