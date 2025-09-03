package com.example.inventory.model;
import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Convert;
import com.example.inventory.model.ListToStringConverter;
@Entity
@Table(name="DeliveryCompanies")

public class DeliveryCompanies{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    @Convert (converter=ListToStringConverter.class)
    private List<String> region;
    private double price;
    private String contactNumber;
    public DeliveryCompanies() {}

    public DeliveryCompanies(String companyName, String contactNumber, double price, List<String> region) {
        this.companyName = companyName;
        this.contactNumber = contactNumber;
        this.price = price;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<String> getRegion(){
        return region;
    }

    public void setRegion(List<String> region){
        this.region=region;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}