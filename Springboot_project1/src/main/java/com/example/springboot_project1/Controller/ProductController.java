package com.example.springboot_project1.Controller;

import com.example.springboot_project1.Pojo.Product;
import com.example.springboot_project1.Service.ProductService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product> products=productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("product add");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id,  @RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=productService.updateProduct(id,product);

        if(isupdated){
            return ResponseEntity.status(200).body("product updated");
        }

        return ResponseEntity.status(400).body("wrong id ");
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        boolean isdeleted=productService.deleteProduct(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("product deleted");
        }
        return ResponseEntity.status(400).body("wrong id");

    }


}
