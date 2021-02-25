package carrental;

public class CarRentalContract {
    private Customer customer;
    private Vehicle vehicle;

    /**
     * Construct and initialize a contract with customer and vehicle details.
     * @param customer initializing the customer object
     * @param vehicle initializing the vehicle object
     */
    public CarRentalContract(Customer customer, Vehicle vehicle) {
        this.customer = customer;
        this.vehicle = vehicle;
    }

    /**
     *  toString displays the details of the customer and the vehicle.
     * @return a String containing all the details about the customer and the vehicle
     */
    @Override
    public String toString() {
        return customer.toString()+ vehicle.toString() ;
    }
}
