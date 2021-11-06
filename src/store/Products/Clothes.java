/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import store.Purchases.Cashier;

/**
 *
 * @author Lenovo
 */
public final class Clothes extends Product {

    public String colour;
    public Size size;

    public Clothes(String name, String brand, double price, Size Size, String color) {
        super(name, brand, price);
        colour = color;
        this.size = Size;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);
    }

    // Overrides Product.SetDiscountInPercent(). There is a 10% discount on all clothes bought during the working days
    @Override
    public int setDiscountInPercent() {
        LocalDateTime dateOfPurchase = Cashier.getDateOfPurchase();
        int disc = 0;

        if (dateOfPurchase.getDayOfWeek().equals(DayOfWeek.MONDAY) || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.TUESDAY)
                || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.WEDNESDAY) || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.THURSDAY)
                || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            disc = 10;

        }
        this.discountPercent = disc;
        return disc;
    }

    @Override
    public void printProduct() {
        System.out.println(this.name + " " + this.brand + " " + this.size + " " + this.colour.toLowerCase());

    }
}
