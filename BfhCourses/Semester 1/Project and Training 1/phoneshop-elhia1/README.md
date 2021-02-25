# PhoneShop

Write a class `PhoneShop` to manage a shop that sells phones and cases to protect the phones.

## Instance Variables 

The class has the following instance variables:

- A `String` to identify the owner of the shop
- An integer with the number of phones in stock
- An integer with the number of cases in stock

## Constructor

Define a constructor with the following signature:
`public PhoneShop(String owner)`

## Methods

The class contains the following methods:

- Getter methods for the instance variables:
`public String getOwner()`
`public int getPhoneStock()`
`public int getPhonecaseStock()`

- Methods to fill up the stock for phones or cases:
`public void fillStockCases(int number)`
`public void fillStockPhones(int number)`

- Define methods to reduce the stock when a phone or a case is sold. It returns `OK` when everything went well, and `NOK` in case there are not enough phones or cases in the stock.
`public String phoneSold()`
`public String caseSold()`
