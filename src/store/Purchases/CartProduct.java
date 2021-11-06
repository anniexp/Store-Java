/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Purchases;

import store.Products.Product;

/**
 *
 * @author Lenovo
 */
public class CartProduct {

    public CartProduct(Product product, int quantity) {
        this.Product = product;
        this.quantity = setQuantity();
    }

    public int quantity;
    public Product Product;

    // sets the number of each product
    public static int setQuantity() {
        int min = 1;
        int max = 5;

        int quantity = (int) (Math.random() * (max - min + 1) + min);

        return quantity;
    }

    public static double sumP(CartProduct cart) {
        double sum;

        sum = cart.quantity * cart.Product.price;

        return Math.round(sum * 100.0) / 100.0;
    }

}
