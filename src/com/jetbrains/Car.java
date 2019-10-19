package com.jetbrains;
import java.lang.String;
public class Car
{
    private String vin;
    private String Brand;
    private String model;
    private int year;
    private int mileage;
    private double price;
    private char color;
    private char isNew;
    private boolean brandNew;

    public Car() {}
    public Car(String V, String B, String M, int Y, int Mileage, Double P, char C, char newOrOld)
    {
        this.vin = V;
        this.Brand = B;
        this.model = M;
        this.year = Y;
        this.mileage = Mileage;
        this.price = P;
        this.color = C;
        this.isNew = newOrOld;
    }
    public void setVin(String vin) { 
        this.vin = vin; 
    }
    public String getVin() { 
        return this.vin; 
    }
    public void setBrand(String brand) { 
        Brand = brand; 
    }
    public String getBrand() {
        return this.Brand; 
    }
    public void setModel(String model) {
        this.model = model; 
    }
    public String getModel() {
        return this.model; 
    }
    public void setYear(int year) {
        this.year = year; 
    }
    public int getYear() { 
        return this.year; 
    }
    public void setMileage(int mileage) {
        this.mileage = mileage; 
    }
    public int getMileage() {
        return this.mileage; 
    }
    public void setPrice(double price) {
        this.price = price; 
    }
    public double getPrice() {
        return this.price; 
    }
    public void setColor(char color) {
        this.color = color; 
    }
    public char getColor() {
        return this.color; 
    }
    public char getIsNew() {
        return this.isNew; 
    }
    public void setBrandNew(boolean brandNew) {
        this.brandNew = brandNew;
    }
    public boolean isBrandNew() {
        return this.brandNew; 
    }
}
