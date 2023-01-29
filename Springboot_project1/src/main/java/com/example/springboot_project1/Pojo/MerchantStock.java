package com.example.springboot_project1.Pojo;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "id must be provided")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int id;
    @NotEmpty(message = "product id must be provided")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private  int productid;
    @NotEmpty(message = "merchant id must be provided")
    @Digits(integer = 3, fraction = 0, message = "Id must be 3 digit")
    private int merchantid;
    @NotEmpty(message = "price must be provided")
    @Min(value = 10,message = "stock must be more than 10")
    private int stock;

}
