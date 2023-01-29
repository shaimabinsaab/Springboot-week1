package com.example.springboot_project1.Service;

import com.example.springboot_project1.Pojo.Merchant;
import com.example.springboot_project1.Pojo.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks=new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return merchantStocks;
    }
    public void addMerchantStock(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);

    }
    public boolean updateMerchantStock(int id, MerchantStock merchantStock){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.set(i,merchantStock);
                return true;
            }

        }
        return false;
    }

    public boolean deleteMerchant(int id){
        for (int i = 0; i <merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }

        }
        return false;
    }
    public boolean checkId(int id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId()==id){
                return true;
            }

        }
        return false;
    }
}
