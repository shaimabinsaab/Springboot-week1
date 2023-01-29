package com.example.springboot_project1.Controller;

import com.example.springboot_project1.Pojo.Category;
import com.example.springboot_project1.Pojo.Merchant;
import com.example.springboot_project1.Service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<Merchant> merchants =merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant add");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @RequestBody Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=merchantService.updateMerchant(id,merchant);

        if(isupdated){
            return ResponseEntity.status(200).body("merchant updated");
        }

        return ResponseEntity.status(400).body("wrong id ");
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id){
        boolean isdeleted=merchantService.deleteMerchant(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("Merchant deleted");
        }
        return ResponseEntity.status(400).body("wrong id");

    }
}
