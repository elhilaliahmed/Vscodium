package carrental;

/**
 * @author ahmed elhilali
 */



public class Car extends Vehicle {
    private boolean hasWinterTire = false;


    /**
     * Construct and initialize a Car with the provided color.
     * @param color is the car's color
     */
    public Car(String color) {
        super(color);
    }

    /**
     * Construct and initialize a Car with the provided color and if it has a winter tire or not.
     * @param color is the car's color
     * @param hasWinterTire is either true or false, indicating if the car has a winter tire or not.
     */
    public Car(String color, boolean hasWinterTire) {
        super(color);
        this.hasWinterTire = hasWinterTire;
    }


    /**
     * Displays the car color and indicates if it has a winter tire or not.
     * @return a String containing the car color and if it has a winter tire or not
     */
    @Override
    public String toString() {
        return super.toString() + ", has WinterTires: " + hasWinterTire;
    }
}
