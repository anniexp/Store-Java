/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products.Perishables;

import java.time.LocalDate;
import store.Products.Product;

/**
 *
 * @author Lenovo
 */
public final class Food extends Perishable {

    @Override
    public String toString() {
        return "Food{" + '}';
    }

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(LocalDate ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    @Override
    public void printProduct() {
        //if the name is in plural verb - remove the s to make the mono
        if (this.name.endsWith("s")) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        System.out.print(this.name.toLowerCase() + " - " + this.brand);
        System.out.println();
    }

    @Override
    public int setDiscountInPercent() {
        return super.setDiscountInPercent();
    }
    //constructor
    public Food(String name, String brand, double price, LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
         ExpirationDate = expirationDate;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);
    }
    
    
    
}


