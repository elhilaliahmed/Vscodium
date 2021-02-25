# CarRental

## Vehicle Class

Write an abstract class `Vehicle`. 
A Vehicle has an instance variable to store the color of the `Vehicle`. 
The color can be retrieved with the `getColor()` method. 
The `toString()` method returns a `String` like `This vehicle is red`, depending on the actual color.

## Car Class

Write a class `Car` that extends the class `Vehicle`. 
A car has an instance variable of type boolean to define whether it has winter tires or not (default value: false). 
The method `toString()` of the class `Car` prints the same message as the method of the class Vehicle, but it does also add another line with the content: 
`has winter tires: true/false`, depending on the actual value.

## Truck Class 

Write a class `Truck` that extends the class `Vehicle`. 
A truck has an instance variable of type boolean to define whether it has a trailer or not (default value: false). 
The method `toString()` of the class Truck prints the same message as the method of the class Vehicle, but it does also add another line with the content: 
`has trailer: true/false`, depending on the actual value.

## Garage Class

Write a class `Garage` that has a `Vehicle` as an instance variable. 
This garage can be used by `Cars` and `Trucks`. 
Define a method `setVehicle(Vehicle parked)` to park a vehicle in the garage. 
Provide a method `toString()` to print a message `Description of the parked vehicle ...` 
followed by the description vehicle that is in the garage at this moment. 
If there is no vehicle in the garage, `"Garage is empty."` should be output.


## GarageTester Class

Write a class `GarageTester` with a method `getExample()` (see template). In this method, create an object of the `Truck` class (color is black, and the truck has no trailer). 
Create an object of the `Garage` class. Put the `Truck` into the `Garage`.

## Customer Class

Write a class `Customer` that contains a name and an address of a customer. 

## CarRentalContract Class

Define a class `CarRentalContract` that contains a `Customer` and a `Vehicle`. 
We assume that one customer can only rent one vehicle at a time. 
This class contains the customer and the vehicle he has currently rented.
`CarRental` has a method `toString()` that returns a String containing the name of the customer and the description of the vehicle, in the following format:

- customername[customeraddress]:vehicledescription

Example:

- `jim jones[Biel/Bienne]:This vehicle is red, has WinterTires: false`

## CarRental Class

Write a class `CarRental` that contains an array of `CarRentalContracts`. 
This array contains all the currently issued contracts. 
The `CarRental` class provides a method to add new contracts (`void addContract(CarRentalContract c1)`) to the array and a method (`String displayContracts()`) that returns all the current rental contracts (by using the `toString()` method of the `CarRentalContract` class), each contract on a new line. 

## Additional Exercise 

Think about the relations between the classes you wrote in this exercise. What is relationship between `Garage` and `CarRental`, if any? (You only have to submit the code, not the answer to this question).
