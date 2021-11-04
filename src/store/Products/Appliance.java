/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import store.Purchases.Cashier;

/**
 *
 * @author Lenovo
 */
public final class Appliance extends Product {

    private String model;
    private LocalDate productionDate;
    private String weight;

    //constructors
    public Appliance(double price) {
        super(price);

    }
    public Appliance(String name, String brand, double price,
            String model, LocalDate productionDate, String weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);
    }

    //getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public void printProduct() {

        System.out.println(this.name + " " + this.brand + " " + this.model);

    }
    
    // Overrides Product.SetDiscountInPercent(). There is a 5% discount on all 
    //appliances that cost above $999 and are purchased during the weekend  
    @Override
    public int setDiscountInPercent() {
        LocalDateTime dateOfPurchase = Cashier.dateOfPurchase;
        int disc = 0;
        if ((dateOfPurchase.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.SUNDAY)) && this.price > 999) {
            disc = 5;

        }
        this.discountPercent = disc;
        return disc;
    }

}
