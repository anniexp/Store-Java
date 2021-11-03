/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Purchases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import store.Store;

/**
 *
 * @author Lenovo
 */
public class Cashier
    {
        public static LocalDateTime dateOfPurchase = Store.dateOfPurchase;

    public static LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public static void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        Cashier.dateOfPurchase = dateOfPurchase;
    }
        
        /// <summary>
        /// Method to print a receipt -  prints all purchased products with their price, quantity, the total sum and the total discount 
        /// </summary>
        /// <param name="listOfProducts"> cart (collection of cart products) </param>
        /// <param name="dateOfPurchase">  the date and time of purchase</param>
        public static void printReceipt(List<CartProduct> listOfProducts, LocalDateTime dateOfPurchase)
        {

          
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String formatDateTime = dateOfPurchase.format(formatter);
            // Console.WriteLine("Date: " + dateOfPurchase.ToString("yyyy-MM-dd ") + dateOfPurchase.Hour + ":" + dateOfPurchase.Minute + ":" +  dateOfPurchase.Second);
            System.out.println("Date: " + formatDateTime);
             System.out.println();
           System.out.println("---Products---");
            System.out.println();



          for (CartProduct cart : listOfProducts)
            {
               System.out.println();

                cart.Product.printProduct();
             //  System.out.println(cart.quantity + " x $" + cart.Product.price + " = $" + CartProduct.sumP(cart));
               System.out.print(cart.quantity + " x $");
               System.out.printf("%.2f = $", cart.Product.price);
                System.out.printf("%.2f", CartProduct.sumP(cart));

               System.out.println();
                if (cart.Product.discount != 0)
                {
                    System.out.print("#discount " +  cart.Product.discountPercent + "% -$");
                    System.out.printf("%.2f", sumDiscountOfSameProducts(cart));
                    System.out.println();

                }

            }

           System.out.println("-----------------------------------------------------------------------------------");
           System.out.println();
           System.out.printf("SUBTOTAL: $%.2f",sumSubtotal(listOfProducts));
                      System.out.println();


            System.out.printf("DISCOUNT: -$%.2f",sumDiscount(listOfProducts));
                       System.out.println();

            double total = sumSubtotal(listOfProducts) - sumDiscount(listOfProducts);
          
            System.out.println();
            

           System.out.printf("TOTAL: $%.2f",total);

        }/// <summary>
         /// Calculates the total sum of all products in the cart in $
         /// </summary>
         /// <param name="listOfProducts">cart</param>
         /// <returns>sum of all products</returns>
        private static double sumSubtotal(List<CartProduct> listOfProducts)
        {
            double sumSubtotal = 0;
            for (CartProduct product : listOfProducts)
            {
                sumSubtotal = CartProduct.sumP(product) + sumSubtotal;
            }
            return sumSubtotal;
        }


        /// <summary>
        /// Calculates the total discount of the products in the cart, as it sums all the discounts of the products in the cart
        /// </summary>
        /// <param name="listOfProducts">cart</param>
        /// <returns>the whole discount</returns>
        private static double sumDiscount(List<CartProduct> listOfProducts)
        {
            double sumDiscount = 0.00;            
            for (CartProduct product : listOfProducts)
                sumDiscount = sumDiscount + sumDiscountOfSameProducts(product);

            return sumDiscount;
        }
        /// <summary>
        /// Calculates the total discount of the products of 1 kind, soit can be written in the receipt
        /// </summary>
        /// <param name="cartProduct"></param>
        /// <returns></returns>
        private static double sumDiscountOfSameProducts(CartProduct cartProduct) 
        {
            double sumDiscount = 0;
            sumDiscount = cartProduct.Product.discount * cartProduct.quantity;
            
            //return Math.round(sumDiscount*100.0)/100.0;
            return sumDiscount;
        }
    }
