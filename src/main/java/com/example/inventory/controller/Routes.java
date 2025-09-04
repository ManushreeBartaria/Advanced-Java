package com.example.inventory.controller;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.inventory.services.inventoryservice;
import com.example.inventory.model.item;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;
import com.example.inventory.model.company;
import com.example.inventory.model.disposed;
import com.example.inventory.model.DeliveryCompanies;
import com.example.inventory.model.delivered;
import com.example.inventory.model.prediction;
@RestController
@RequestMapping("/api/inventory")
public class Routes{
     @Autowired
    private inventoryservice InventoryService;
    @GetMapping("/routes")
    public String routes() {
        return "Inventory Service is up and running! 🚀";
    }

    @PostMapping("/addItem")
    public item addItem(@RequestBody item newitem) { 
        return InventoryService.add(newitem);
    }

    @GetMapping("/expired")
    public List<item> expired(){
        return InventoryService.getExpiredItems();
    }

    @GetMapping("/aboutToExpire")
    public List<item> aboutToExpire(){
        return InventoryService.getaboutToExpireItems();
    }

    @PostMapping("/registerCompany")
    public company registerCompany(@RequestBody company newcompany){     
            return InventoryService.addCompany(newcompany);
    }
    
    @PostMapping("/dispose/request")
    public List<company> requestDisposal(@RequestBody Map<String, Integer> request) {
        return InventoryService.disposeRequest(request.get("id"));
    }

    @PostMapping("/dispose/confirm")
    public disposed confirmDisposal(@RequestBody Map<String,Integer> request){
        return InventoryService.confirmDisposal(request.get("itemId"), request.get("companyId"));
    }   

    @PostMapping("/registerDeliveryCompanies")
    public DeliveryCompanies registerDeliveryCompanies(@RequestBody DeliveryCompanies newDeliveryCompanies){     
            return InventoryService.addDeliveryCompanies(newDeliveryCompanies);
    }

    @PostMapping("/delivery")
    public List<DeliveryCompanies> delivery(@RequestBody Map<String, String> request){
        return InventoryService.getDeliveryCompaniesByLocation(request.get("location"));
    }

    @PostMapping("/delivered")
    public delivered delivered(@RequestBody Map<String, Integer> request){
        return InventoryService.markAsDelivered(request.get("itemId"), request.get("deliveryCompanyId"));
    }

    @PostMapping("/allProductsPrediction")
    public List<prediction> allProductsPrediction(@RequestBody Map<String, String> request){
        return InventoryService.getAllProductsPrediction(request.get("region"),request.get("season"));
    }
}