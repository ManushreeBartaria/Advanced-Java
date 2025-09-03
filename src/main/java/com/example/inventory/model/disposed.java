package com.example.inventory.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="disposed")
public class disposed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int item_id;
    private String itemName;
    private int company_id;
    private String companyName;
    private LocalDate disposedDate;
    

    public disposed() {}

    public disposed(String itemName, String companyName, LocalDate disposedDate, int company_id, int item_id) {
        this.itemName = itemName;
        this.companyName = companyName;
        this.company_id = company_id;
        this.item_id = item_id;
        this.disposedDate = disposedDate;
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

    public LocalDate getDisposedDate() {
        return disposedDate;
    }

    public void setDisposedDate(LocalDate disposedDate) {
        this.disposedDate = disposedDate;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public int getCompany_id() {
        return company_id;
    }
   public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}