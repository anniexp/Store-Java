# Store

For the creation of the application is used NetBeans IDE and library JDK 1.8.



Description of the content of Store :

In a store you can buy different products - food, beverages, clothes, appliances.

Each product has a name, brand and price. 

The perishable products (food and beverages) have expiration dates as well. 

For the clothes a size (standard from XS, S, M, L, XL) and color is stored, and for appliances - model, production date and weight (in kg).

If perishable products are about to expire a discount is added - 10% if the expiration date is within 5 days of the purchase date and 50% if the product expires at the date of purchase.

There is a 10% discount on all clothes bought during the working days, and 5% discount on all appliances that cost above $999 and are purchased during the weekend.


There is a class Cashier that has a method to print a receipt. The method accepts a cart (collection of products) and the date and time of purchase. It should print all purchased products with their price, quantity, the total sum and the total discount. 


