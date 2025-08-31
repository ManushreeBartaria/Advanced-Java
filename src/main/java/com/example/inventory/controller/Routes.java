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
}