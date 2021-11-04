/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products.Perishables;

import store.Products.Product;
import java.time.LocalDate;
import java.time.LocalDateTime;

import store.Store;

/**
 *
 * @author Lenovo
 */
public abstract class Perishable extends Product {

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(LocalDate ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }
    public LocalDate ExpirationDate;

    protected Perishable(String name, String brand, double price,
            LocalDate expirationDate) {
        super(name, brand, price);
        ExpirationDate = expirationDate;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);
    }

    @Override
    public final int setDiscountInPercent() {
        LocalDateTime dateAndTimeOfPurchase = Store.dateOfPurchase;
        //get only the date 
        LocalDate dateOfPurchase = dateAndTimeOfPurchase.toLocalDate();
        int disc = 0;
        //not sure if in the assigegment to be with the 5th day or not
        if ((dateOfPurchase.isAfter(ExpirationDate.minusDays(5)) || dateOfPurchase.isEqual(ExpirationDate.minusDays(5)))) {
            disc = 10;
            if (dateOfPurchase.isEqual(ExpirationDate)) {
                disc = 50;
            }
        }
        this.discountPercent = disc;
        return disc;
    }

    @Override
    public void printProduct() {
    }

}
