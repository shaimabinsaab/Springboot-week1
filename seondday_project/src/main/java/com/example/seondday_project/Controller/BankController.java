package com.example.seondday_project.Controller;

import com.example.seondday_project.Pojo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
    ArrayList<Customers> customers=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customers;
    }
    @PostMapping("/add")
    public String addcustomer(@RequestBody Customers customer){
        customers.add(customer);
        return "customer added";
    }

    @PutMapping("/update/{index}")
    public String update(@PathVariable int index,Customers customer){
        customers.set(index,customer);
        return "done update";
    }

    @GetMapping("delet/{index}")
    public String delete(@PathVariable int index){
        customers.remove(index);
        return "customer removed";
    }

    @PutMapping("/deposite/{index}")
    public int deposite(@PathVariable int index,@RequestBody Customers customer){
        int newbalance=500;
        newbalance+=customer.getBalance();
        customer.setBalance(newbalance);
        customers.set(index,customer);
        return newbalance;
    }

    @PutMapping("/withdraw/{index}")
    public int withdraw(@PathVariable int index,@RequestBody Customers customer){
        int withdraw=400;
        int newbalance;

        if (customer.getBalance()<=withdraw)
            System.out.println("your balance not enough!!");

        newbalance=customer.getBalance()-withdraw;
        customer.setBalance(newbalance);

        customers.set(index,customer);
        return newbalance;


    }





}
