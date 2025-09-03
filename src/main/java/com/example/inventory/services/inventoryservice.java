package com.example.inventory.services;
import java.util.*;
import com.example.inventory.model.item;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.repository.CompanyRepository;
import com.example.inventory.repository.DisposedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.inventory.model.company;
import com.example.inventory.model.disposed;
@Service
public class inventoryservice {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DisposedRepository disposedRepository;
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

    public disposed confirmDisposal(int itemId, int companyId){
        item i=inventoryRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with id " + itemId));
        int items_id = i.getId();
        String itemName= i.getItemName();
        inventoryRepository.deleteById(itemId);
        company c=companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Item not found with id " + companyId));
        int companys_id= c.getId();
        String companyName= c.getCompanyName();
        return disposedRepository.save(new disposed(itemName, companyName, LocalDate.now(), companys_id, items_id));
    }
}