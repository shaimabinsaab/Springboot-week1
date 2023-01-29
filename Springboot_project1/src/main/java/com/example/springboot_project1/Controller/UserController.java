package com.example.springboot_project1.Controller;

import com.example.springboot_project1.Pojo.Merchant;
import com.example.springboot_project1.Pojo.MerchantStock;
import com.example.springboot_project1.Pojo.User;
import com.example.springboot_project1.Service.MerchantService;
import com.example.springboot_project1.Service.MerchantStockService;
import com.example.springboot_project1.Service.ProductService;
import com.example.springboot_project1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;
    private final ProductService productService;

    private final MerchantStock merchantStock;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        ArrayList<User>users=userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user add");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean IsUpdated=userService.UpdateUser(id,user);

        if(IsUpdated){
            return ResponseEntity.status(200).body("user added");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletUser(@PathVariable int id){
        boolean isdeleted=userService.DeleteUser(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("User deleted");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
    @PostMapping("/addproduct")
    public ResponseEntity addproduct(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addprouduct(merchantStock);
        return ResponseEntity.status(200).body("product added");
    }

    @PutMapping("/buy/{userid}/{productid}/{merchantid}")
        public ResponseEntity buy(@PathVariable int userid,@PathVariable int productid,@PathVariable int merchantid){
            boolean ismerchantvaled=merchantService.checkId(merchantid);
            boolean isproductvalid=productService.checkid(productid);
            boolean isuservalid=userService.checkId(userid);

            if(ismerchantvaled && isproductvalid && isuservalid){
                boolean istrue =userService.buyproduct(productid,merchantid);
                if (istrue){
                    return ResponseEntity.status(200).body("payment done ");

                }
            }

                return ResponseEntity.status(400).body("there is problem");






        }


}
