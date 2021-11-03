/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import store.Products.Appliance;
import store.Products.Clothes;
import store.Products.Perishables.Beverage;
import store.Products.Perishables.Food;
import store.Products.Size;
import static store.Products.Size.M;
import store.Purchases.CartProduct;
import store.Purchases.Cashier;

/**
 *
 * @author Lenovo
 */
public class Store {

    /**
     * @param args the command line arguments
     */
    
    public static DecimalFormat f = new DecimalFormat("##.00");
    public static LocalDateTime dateOfPurchase;

    public static void main(String[] args) {
        // TODO code application logic here
        
       dateOfPurchase =  LocalDateTime.now();
            //dateOfPurchase = DateTime.Now.AddDays(2);


            Clothes clothes1 = new Clothes("T-shirt", "Chanel", 1111f, Size.L, "red");
            Clothes clothes2 = new Clothes("T-shirt", "Chanel", 1121.99f, Size.M, "blue");
            Clothes clothes3 = new Clothes("dress", "Versache", 2211.11f, Size.S, "black");

            Food food1 = new Food("Breads", "Zemel", 1.25f,  LocalDate.of(2021,11,3));
            Food food2 = new Food("Sour milk", "Elena", 1.05f,LocalDate.of(2021, 11, 28));

            Beverage beverage1 = new Beverage("water", "Devin", 1.50f, LocalDate.of(2021, 11, 3));
            Beverage beverage2 = new Beverage("water", "Devin", 1.50f,  LocalDate.of(2021, 11, 3));

            Appliance app1 = new Appliance("laptop", "BrandL", 2345f, "ModelL",  LocalDate.of(2021, 03, 03), "1.125 kg");

            CartProduct prod1 = new CartProduct(clothes1, CartProduct.setQuantity());
            CartProduct prod2 = new CartProduct(clothes2, CartProduct.setQuantity());
            CartProduct prod3 = new CartProduct(clothes3, CartProduct.setQuantity());
            CartProduct prod4 = new CartProduct(food1, CartProduct.setQuantity());
            CartProduct prod5 = new CartProduct(food2, CartProduct.setQuantity());
            CartProduct prod6 = new CartProduct(beverage1, CartProduct.setQuantity());
            CartProduct prod7 = new CartProduct(app1, CartProduct.setQuantity());

            CartProduct prof8 = new CartProduct(beverage2, CartProduct.setQuantity());

            List<CartProduct> cart = new ArrayList<CartProduct>();
            cart.add(prod1);
            cart.add(prod2);
            cart.add(prod3);
            cart.add(prod4);
            cart.add(prod5);
            cart.add(prod6);
            cart.add(prod7);
            cart.add(prof8);

            Cashier.printReceipt(cart, dateOfPurchase);
           


        }
    }
    

