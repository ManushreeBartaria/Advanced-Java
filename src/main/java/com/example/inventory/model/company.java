package com.example.inventory.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.Convert;
@Entity
@Table(name="Companies")
public class company{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;

    @Convert (converter=ListToStringConverter.class)
    private List<String> category;
    private double price;
    public company() {}

    public company(String companyName, List<String> category, double price) {
        this.companyName = companyName;
        this.category = category;
        this.price = price;
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
    public List<String> getCategory(){
        return category;
    }
    public void setCategory(List<String> category){
        this.category=category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}