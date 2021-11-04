/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products;

import java.text.DecimalFormat;

/**
 *
 * @author Lenovo
 */
public abstract class Product {

    public static DecimalFormat f = new DecimalFormat("##.00");

    //properties
    public String name;
    public String brand;
    public double price;
    public int discountPercent;
    public double discount;
    

   
    //constructors
    protected Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price =Math.round(price*100.0)/100.0;

    }

    protected Product(double price) {

        this.price = Math.round(price*100.0)/100.0;
    }
    //getters and setters
     public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscount() {
        return discount;
    }

    
    // abstract method for calculating discount percent - must be overrided in each child class
    //returns discount in percent
    public abstract int setDiscountInPercent();
    
    // Gets the value of the discount. Equals original price * discount in percents / 100

    //price - original price 
    //discount - discount in percent
    //returns  discount 

    public static double getValueOfDiscount(double price, int discountInPercent) {
        double discount;
        //x - x*y/100 (new price = old price - discount)
        discount = (discountInPercent * price) / 100;    
        
        return discount ;
    }

    public abstract void printProduct();

}
