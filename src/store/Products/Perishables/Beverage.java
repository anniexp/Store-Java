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
public final class Beverage extends Perishable {

    @Override
    public void printProduct() {
        //if the name is in plural verb - remove the s to make the mono
        if (this.name.endsWith("s")) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        System.out.print(this.name.toLowerCase() + "  " + this.brand);
        System.out.println();
//To change body of generated methods, choose Tools | Templates.
    }

    public Beverage(String name, String brand, double price,
            LocalDate expirationDate) {
        super(name, brand, price, expirationDate);
        ExpirationDate = expirationDate;
        this.discountPercent = setDiscountInPercent();
        this.discount = Product.getValueOfDiscount(price, discountPercent);

    }

}
