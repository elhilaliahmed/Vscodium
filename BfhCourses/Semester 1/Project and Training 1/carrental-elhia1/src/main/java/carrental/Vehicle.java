package carrental;

public abstract class Vehicle{


    private String color;

    /**
     * Construct and initialize a vehicle with the provided color.
     * @param color is the vehicle's color
     */
    public Vehicle(String color) {
        this.color = color;
    }

    /**
     * Displays the vehicle's color.
     * @return a String containing the vehicle's color
     */
    @Override
    public String toString() {
        return "This vehicle is " + color;
    }
}
