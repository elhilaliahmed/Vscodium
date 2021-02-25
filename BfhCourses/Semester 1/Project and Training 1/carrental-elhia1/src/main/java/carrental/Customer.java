package carrental;

public class Customer {
    private String name;
    private String address;

    /**
     * Construct and initialize and customer with the provided name and address.
     * @param name of the customer
     * @param address of the customer
     */
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     *  Display the customer name and address.
     * @return a String cotaining the name and the address of the customer
     */
    @Override
    public String toString() {
        return name + "[" + address + "]:";
    }
}
