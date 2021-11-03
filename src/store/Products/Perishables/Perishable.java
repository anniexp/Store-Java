/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products.Perishables;

import store.Products.Product;
import java.time.LocalDate; // import the LocalDate class

import store.Purchases.Cashier;

/**
 *
 * @author Lenovo
 */



    public abstract class Perishable extends Product
    {

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(LocalDate ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }
        public LocalDate  ExpirationDate  ;
                 
        protected Perishable(String name, String brand, double price,
            LocalDate expirationDate) 
        {
            super(name, brand, price);
            ExpirationDate = expirationDate;
            this.discountPercent = setDiscountInPercent();
            this.discount = Product.getValueOfDiscount(price, discountPercent);
        }

        @Override
        public  int setDiscountInPercent()
        {
            LocalDate dateOfPurchase = LocalDate.now();
                    //Cashier.dateOfPurchase;
            int disc = 0;
          //  if (dateOfPurchase >= this.ExpirationDate.Date.AddDays(-5) && dateOfPurchase <= this.ExpirationDate.Date)
              if ((dateOfPurchase.isAfter(ExpirationDate.minusDays(5)) || dateOfPurchase.isEqual(ExpirationDate.minusDays(5) )) && dateOfPurchase.isBefore(ExpirationDate))

            {
                disc = 10;
                if (dateOfPurchase.isEqual(ExpirationDate))
                {
                    disc = 50;
                }
            }
            this.discountPercent = disc;
            return disc;
        }
        @Override
        public void printProduct(){}
    
    }


