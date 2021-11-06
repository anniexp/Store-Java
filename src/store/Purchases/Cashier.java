/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Purchases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Cashier {

    private static LocalDateTime dateOfPurchase;

    //  public static LocalDateTime dateOfPurchase = Store.dateOfPurchase;
    public static LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public static void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        Cashier.dateOfPurchase = dateOfPurchase;
    }

    //Method to print a receipt -  prints all purchased products with their price, quantity, the total sum and the total discount 
    // listOfProducts - cart (collection of cart products) 
    //dateOfPurchase" -  the date and time of purchase
    public static void printReceipt(List<CartProduct> listOfProducts, LocalDateTime dateOfPurchase) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = dateOfPurchase.format(formatter);
        System.out.println("Date: " + formatDateTime);
        System.out.println();
        System.out.println("---Products---");
        System.out.println();

        for (CartProduct cart : listOfProducts) {
            System.out.println();
            System.out.println();

            cart.Product.printProduct();
            System.out.print(cart.quantity + " x $");
            //prints with 2 digits after .
            System.out.printf("%.2f = $", cart.Product.price);
            System.out.printf("%.2f", CartProduct.sumP(cart));
            System.out.println();
            if (cart.Product.discount != 0) {
                System.out.print("#discount " + cart.Product.discountPercent + "% -$");
                System.out.printf("%.2f", sumDiscountOfSameProducts(cart));
                System.out.println();

            }
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("SUBTOTAL: $%.2f", sumSubtotal(listOfProducts));
        System.out.println();

        System.out.printf("DISCOUNT: -$%.2f", sumDiscount(listOfProducts));
        System.out.println();

        double total = sumSubtotal(listOfProducts) - sumDiscount(listOfProducts);

        System.out.println();
        System.out.printf("TOTAL: $%.2f", total);

    }
    // Calculates the total sum of all products in the cart in $
    //listOfProducts - cart
    // returns - sum of all products

    private static double sumSubtotal(List<CartProduct> listOfProducts) {
        double sumSubtotal = 0;
        for (CartProduct product : listOfProducts) {
            sumSubtotal = CartProduct.sumP(product) + sumSubtotal;
        }
        return sumSubtotal;
    }

    //Calculates the total discount of the products in the cart, as it sums all the discounts of the products in the cart
    ///listOfProducts -cart
    //returns the whole discount
    private static double sumDiscount(List<CartProduct> listOfProducts) {
        double sumDiscount = 0.00;
        for (CartProduct product : listOfProducts) {
            sumDiscount = sumDiscount + sumDiscountOfSameProducts(product);
        }

        return sumDiscount;
    }

    // Calculates the total discount of the products of 1 kind, soit can be written in the receipt            
    private static double sumDiscountOfSameProducts(CartProduct cartProduct) {
        double sumDiscount = 0;
        sumDiscount = cartProduct.Product.discount * cartProduct.quantity;

        return sumDiscount;
    }
}
