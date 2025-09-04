package com.example.inventory.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

public class prediction{
    private String itemName;
    private String region;
    private String season;
    private int predictedStock;

    public prediction() {}

    public prediction(String itemName, int predictedStock, String region, String season) {
        this.itemName = itemName;
        this.predictedStock = predictedStock;
        this.region = region;
        this.season = season;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPredictedStock() {
        return predictedStock;
    }
    public void setPredictedStock(int predictedStock) {
        this.predictedStock = predictedStock;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }

}