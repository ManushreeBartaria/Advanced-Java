package com.example.inventory.services;
import java.util.*;
import com.example.inventory.model.item;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.repository.CompanyRepository;
import com.example.inventory.repository.DisposedRepository;
import com.example.inventory.repository.DeliveryCompanyRepository;
import com.example.inventory.repository.DeliveredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.inventory.model.company;
import com.example.inventory.model.disposed;
import com.example.inventory.model.DeliveryCompanies;
import com.example.inventory.model.delivered;
import com.example.inventory.model.prediction;
@Service
public class inventoryservice {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DisposedRepository disposedRepository;
    @Autowired
    private DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    private DeliveredRepository deliveredRepository;
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
        List<company> companies=companyRepository.findbyitem(item);
        return companies;
    }

    public disposed confirmDisposal(int itemId, int companyId){
        item i=inventoryRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with id " + itemId));
        int items_id = i.getId();
        String itemName= i.getItemName();
        inventoryRepository.deleteById(itemId);
        company c=companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found with id " + companyId));
        int companys_id= c.getId();
        String companyName= c.getCompanyName();
        return disposedRepository.save(new disposed(itemName, companyName, LocalDate.now(), companys_id, items_id));
    }

    public DeliveryCompanies addDeliveryCompanies(DeliveryCompanies newDeliveryCompanies){
        return deliveryCompanyRepository.save(newDeliveryCompanies); 
    }

    public List<DeliveryCompanies> getDeliveryCompaniesByLocation(String location){
        return deliveryCompanyRepository.findByregion(location);
    }

    public delivered markAsDelivered(int itemId, int deliveryCompanyId){
        item i=inventoryRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with id " + itemId));
        String itemName= i.getItemName();
        DeliveryCompanies d=deliveryCompanyRepository.findById(deliveryCompanyId).orElseThrow(() -> new RuntimeException("Item not found with id " + deliveryCompanyId));
        int delivery_company_id= d.getId();
        String companyName= d.getCompanyName();
        delivered newdelivered = new delivered(itemName, delivery_company_id, LocalDate.now(), companyName);
        return deliveredRepository.save(newdelivered);
      
    }

    public List<prediction> getAllProductsPrediction(String region, String season) {
            List<item> items = inventoryRepository.findAllItems();
            System.out.println(items);
            List<prediction> p = new ArrayList<>();

            String Nwinter[] = {"milk", "eggs", "butter", "cheese", "bread", "wheat flour", "ghee", "paneer", "potatoes", "tea"};
            String Nsummer[] = {"milk", "curd", "lassi", "buttermilk", "icecream", "bread", "cucumber", "watermelon", "cold drinks", "lemon"};
            String Swinter[] = {"milk", "eggs", "butter", "bread", "rice", "sambar powder", "coconut oil", "idli batter", "upma rava", "filter coffee"};
            String Ssummer[] = {"buttermilk", "curd", "rice", "rasam powder", "tender coconut water", "idli batter", "dosa batter", "mangoes", "lemon rice mix", "cold drinks"};
            String Wwinter[] = {"milk", "cheese", "butter", "eggs", "bread", "wheat flour", "poha", "jaggery", "tea", "dry fruits"};
            String Wsummer[] = {"milk", "curd", "lassi", "buttermilk", "sugarcane juice", "mangoes", "cold drinks", "groundnuts", "ice cream", "watermelon"};
            String Ewinter[] = {"milk", "eggs", "bread", "paneer", "mustard oil", "potatoes", "tea", "puffed rice", "jaggery", "fish"};
            String Esummer[] = {"milk", "curd", "lassi", "fish", "rice", "coconut water", "sugarcane juice", "mangoes", "cold drinks", "jackfruit"};

            for (item ite : items) {
                String itemName = ite.getItemName().trim().toLowerCase();
                int predictedQty = 0;
                if (region.equalsIgnoreCase("North") && season.equalsIgnoreCase("Winter")) {
                    if (Arrays.asList(Nwinter).contains(itemName)) {
                        predictedQty = 40;
                        p.add(new prediction(itemName, predictedQty, "North", "Winter"));
                    }
                } else if (region.equalsIgnoreCase("North") && season.equalsIgnoreCase("Summer")) {
                    if (Arrays.asList(Nsummer).contains(itemName)) {
                        predictedQty = 60;
                        p.add(new prediction(itemName, predictedQty, "North", "Summer"));
                    }
                } else if (region.equalsIgnoreCase("South") && season.equalsIgnoreCase("Winter")) {
                    if (Arrays.asList(Swinter).contains(itemName)) {
                        predictedQty = 35;
                        p.add(new prediction(itemName, predictedQty, "South", "Winter"));
                    }
                } else if (region.equalsIgnoreCase("South") && season.equalsIgnoreCase("Summer")) {
                    if (Arrays.asList(Ssummer).contains(itemName)) {
                        predictedQty = 55;
                        p.add(new prediction(itemName, predictedQty, "South", "Summer"));
                    }
                } else if (region.equalsIgnoreCase("East") && season.equalsIgnoreCase("Winter")) {
                    if (Arrays.asList(Ewinter).contains(itemName)) {
                        predictedQty = 30;
                        p.add(new prediction(itemName, predictedQty, "East", "Winter"));
                    }
                } else if (region.equalsIgnoreCase("East") && season.equalsIgnoreCase("Summer")) {
                    if (Arrays.asList(Esummer).contains(itemName)) {
                        predictedQty = 50;
                        p.add(new prediction(itemName, predictedQty, "East", "Summer"));
                    }
                } else if (region.equalsIgnoreCase("West") && season.equalsIgnoreCase("Winter")) {
                    if (Arrays.asList(Wwinter).contains(itemName)) {
                        predictedQty = 45;
                        p.add(new prediction(itemName, predictedQty, "West", "Winter"));
                    }
                } else if (region.equalsIgnoreCase("West") && season.equalsIgnoreCase("Summer")) {
                    if (Arrays.asList(Wsummer).contains(itemName)) {
                        predictedQty = 65;
                        p.add(new prediction(itemName, predictedQty, "West", "Summer"));
                    }
                }
                 System.out.println(p);
            }
           
            return p;
        }

}
