/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Purchases;

import java.util.Random;
import store.Products.Product;

/**
 *
 * @author Lenovo
 */
public class CartProduct {

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return Product;
    }
    public int quantity;
    public Product Product;
    //constructors

    public CartProduct() {
    }

    public CartProduct(Product product, int quantity) {
        this.Product = product;
        this.quantity = setQuantity();
    }

    /// <summary>
    /// sets the number of each product ( )
    /// </summary>
    /// <returns></returns>
    public static int setQuantity() {
        int min = 1;
        int max = 5;

        int quantity = (int) (Math.random() * (max - min + 1) + min);

        return quantity;
    }

    /// <summary>
    /// 
    /// </summary>
    /// <param name="cart"></param>
    /// <returns></returns>
    public static double sumP(CartProduct cart) {
        double sum;

        sum = cart.quantity * cart.Product.price;

        
        return Math.round(sum*100.0)/100.0;
    }

}
