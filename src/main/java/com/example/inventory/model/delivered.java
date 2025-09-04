package com.example.inventory.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="delivered")
public class delivered{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemName;
    private int delivery_company_id;
    private String companyName;
    private LocalDate deliveryDate;

    public delivered() {}

    public delivered(String itemName, int delivery_company_id, LocalDate deliveryDate, String companyName) {
        this.itemName = itemName;
        this.delivery_company_id = delivery_company_id;
        this.companyName = companyName;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getDelivery_company_id() {
        return delivery_company_id;
    }

    public void setDelivery_company_id(int delivery_company_id) {
        this.delivery_company_id = delivery_company_id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}