package com.example.inventory.services;
import java.util.*;
import com.example.inventory.model.item;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.inventory.model.company;
@Service
public class inventoryservice {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CompanyRepository companyRepository;
    public item add(item newitem){
        try{
            return inventoryRepository.save(newitem);
        }
        catch(Exception e){
            System.out.println("Error saving item: " + e.getMessage());
            return null;
        }
     }
         public item fetch(int id){
        return inventoryRepository.findById(id).orElse(null);
    }
    public List<item> getExpiredItems(){
        List<item> expiredItems=inventoryRepository.findByExpiryBefore(LocalDate.now());
        return expiredItems;
    }
    public List<item> getaboutToExpireItems(){
        return inventoryRepository.findByabouttogetexpired();
    }
    
    public company addCompany(company newcompany){
        return companyRepository.save(newcompany); 
    }

    public List<company> disposeRequest(int itemId){
        String item=inventoryRepository.findByname(itemId);
        List<company> companys=companyRepository.findbyitem(item);
        return companys;
    }
}