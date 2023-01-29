package com.example.springboot_project1.Service;

import com.example.springboot_project1.Pojo.MerchantStock;
import com.example.springboot_project1.Pojo.Product;
import com.example.springboot_project1.Pojo.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users=new ArrayList<>();
    private final MerchantStockService merchantStockService;
    private final ProductService productService;


    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(@Valid User user){
        users.add(user);
    }

    public boolean UpdateUser(int id,User user){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }


        }
        return false;
    }

    public boolean DeleteUser(int id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==id){
                users.remove(i);
                return true;
            }


        }
        return false;

    }

    public void addprouduct(MerchantStock merchantStock){
        merchantStockService.addMerchantStock(merchantStock);
    }
    public boolean checkId(int id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId()==id){
                return true;
            }


        }
        return false;

    }

    public boolean buyproduct(int productid,int merchantid){
        for (int i = 0; i < merchantStockService.getMerchantStocks().size(); i++) {
            if(productid==merchantStockService.getMerchantStocks().get(i).getProductid()){
                for (int j = 0; j < users.size(); j++) {
                    if (users.get(j).getBalance()>=productService.getProducts().get(j).getPrice()) {
                        users.get(j).setBalance(users.get(j).getBalance()-productService.getProducts().get(j).getPrice());
                        merchantStockService.getMerchantStocks().get(j).setStock(merchantStockService.getMerchantStocks().get(j).getStock()-1);
                        return true;

                    }

                }
            }


        }
        return false;

    }




}