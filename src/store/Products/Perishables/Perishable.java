/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products.Perishables;

import store.Products.Product;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static store.Purchases.Cashier.getDateOfPurchase;

/**
 *
 * @author Lenovo
 */
public abstract class Perishable extends Product {

    public LocalDate expirationDate;

    protected Perishable(String name, String brand, double price,
            LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);
    }

    @Override
    public final int setDiscountInPercent() {
        LocalDateTime dateAndTimeOfPurchase = getDateOfPurchase();
        //get only the date 
        LocalDate dateOfPurchase = dateAndTimeOfPurchase.toLocalDate();
        int disc = 0;
        //not sure if in the assigegment to be with the 5th day or not
        if ((dateOfPurchase.isAfter(expirationDate.minusDays(5)) || dateOfPurchase.isEqual(expirationDate.minusDays(5)))) {
            disc = 10;
            if (dateOfPurchase.isEqual(expirationDate)) {
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
