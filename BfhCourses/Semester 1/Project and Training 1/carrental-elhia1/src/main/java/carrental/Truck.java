package carrental;

public class Truck extends Vehicle {

    private boolean hasTrailer = false;


    /**
     * Construct and initialize a Truck with the provided color.
     * @param color is the truck's color
     */
    public Truck(String color) {
        super(color);
    }


    /**
     * Construct and initialize a Truck with the provided color and if it has a trailer or not.
     * @param color is the truck's color
     * @param hasTrailer is either true or false, indicating if the truck has trailer or not.
     */
    public Truck(String color, boolean hasTrailer) {
        super(color);
        this.hasTrailer = hasTrailer;
    }

    /**
     * Displays the truck's color and indicates if it has a trailer or not.
     * @return a String containing the truck's color and if it has a trailer or not
     */
    @Override
    public String toString() {
        return super.toString() + ", has Trailer: " + hasTrailer;
    }
}
