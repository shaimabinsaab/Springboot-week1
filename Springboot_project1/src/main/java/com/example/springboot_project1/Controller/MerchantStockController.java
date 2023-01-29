package com.example.springboot_project1.Controller;

import com.example.springboot_project1.Pojo.MerchantStock;
import com.example.springboot_project1.Pojo.Product;
import com.example.springboot_project1.Service.MerchantStockService;
import com.example.springboot_project1.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/merchantstock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        ArrayList<MerchantStock> merchantStocks=merchantStockService.getMerchantStocks();
        return ResponseEntity.status(200).body(merchantStocks);
    }
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("merchant stock add");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantstock(@PathVariable int id, @RequestBody MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=merchantStockService.updateMerchantStock(id,merchantStock);

        if(isupdated){
            return ResponseEntity.status(200).body("merchant stock updated");
        }

        return ResponseEntity.status(400).body("wrong id ");
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        boolean isdeleted=merchantStockService.deleteMerchant(id);

        if(isdeleted){
            return ResponseEntity.status(200).body("merchant stock deleted");
        }
        return ResponseEntity.status(400).body("wrong id");

    }
}
