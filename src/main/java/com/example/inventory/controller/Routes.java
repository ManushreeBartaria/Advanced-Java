package com.example.inventory.controller;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/inventory")
class Routes{
    @GetMapping("/routes")
    public String routes() {
        return "Inventory Service is up and running! 🚀";
    }
    @GetMapping("/predict")
    public Map<String,Object> predict(@RequestParam(defaultValue ="Maharashtra") String region,@RequestParam(defaultValue="Summer") String season,@RequestParam(defaultValue="Cold Drink")  String item){
          Map<String,Object> response = new HashMap<>();
          response.put("region", region);   
          response.put("season", season);
          response.put("item", item);
          int demand;
          if(response.get("item").equals("Cold Drink") && response.get("season").equals("Summer") && response.get("region").equals("Maharashtra") ){
              demand=150;
          } else if(response.get("item").equals("Icecream") && response.get("season").equals("Winter") && response.get("region").equals("Maharashtra")){
              demand=50;
          } else {
              demand=-1;
          }
          response.put("demand",demand==-1?"unknown":demand);
          return response;
    }
    @PostMapping("/addItem")
    public Map<String,Object> addItem(@RequestParam(defaultValue="Icecream") String itemName,@RequestParam(defaultValue="150") int quantity, @RequestParam(defaultValue="7/8/25") String expiry , @RequestParam(defaultValue="Maharashtra") String region){ 
        Map<String,Object> response = new HashMap<>();
        response.put("itemName", itemName);
        response.put("quantity",quantity);
        response.put("expiry",expiry);
        response.put("region",region);
        return response;
    }
}