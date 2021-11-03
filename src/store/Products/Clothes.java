/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.Products;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import store.Purchases.Cashier;

/**
 *
 * @author Lenovo
 */
public final  class Clothes extends Product
    {

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

        public String colour;
        public Size size ;

        /*  public Clothes(string name, string brand, decimal price, Size size, int discountPercent , decimal discount, string color) : base(name, brand, price,discountPercent , discount)
            {
                Colour = color;
             this.Size = size;
             this.DiscountPercent = SetDiscountInPercent();
             this.Discount = Math.Round(Product.GetValueOfDiscount(Price, DiscountPercent), 2);
            }*/

        public Clothes(String name, String brand, double price, Size Size, String color) 
        {
            super(name, brand, price);
            colour = color;
            this.size = Size;
            this.discountPercent = setDiscountInPercent();
            this.discount = Product.getValueOfDiscount(price, discountPercent);
        }     
        
        /// <summary>
        /// Overrides abstract method Product.PrintProduct()
        /// </summary>
      

        // Overrides Product.SetDiscountInPercent(). There is a 10% discount on all clothes bought during the working days
    @Override
    public int setDiscountInPercent() {
       LocalDateTime dateOfPurchase = Cashier.dateOfPurchase;
            int disc = 0;



           if (dateOfPurchase.getDayOfWeek().equals(DayOfWeek.MONDAY) || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.TUESDAY ) ||
               dateOfPurchase.getDayOfWeek().equals(DayOfWeek.WEDNESDAY) ||dateOfPurchase.getDayOfWeek().equals(DayOfWeek.THURSDAY)
                || dateOfPurchase.getDayOfWeek().equals(DayOfWeek.FRIDAY))
            {
                disc = 10;

            }
           

            this.discountPercent = disc;
            return disc;
    }

    @Override
    public void printProduct() {
        System.out.println(this.name + " " + this.brand + " " + this.size + " " + this.colour.toLowerCase());
             System.out.println();

    }
    }


