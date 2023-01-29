package com.example.springboot_project1.Controller;

import com.example.springboot_project1.Pojo.Category;
import com.example.springboot_project1.Pojo.Product;
import com.example.springboot_project1.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCategory(){
        ArrayList<Category> category =categoryService.getCategories();
        return ResponseEntity.status(200).body(category);
    }
    @PostMapping("/add")
    public ResponseEntity addcategory(@RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCtogary(category);
        return ResponseEntity.status(200).body("Ctegory add");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @RequestBody Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=categoryService.updateCategory(id,category);

        if(isupdated){
            return ResponseEntity.status(200).body("category updated");
        }

        return ResponseEntity.status(400).body("wrong id ");
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){
        boolean isdeleted=categoryService.deleteCategory(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("category deleted");
        }
        return ResponseEntity.status(400).body("wrong id");

    }

}
