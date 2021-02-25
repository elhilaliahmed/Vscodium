package carrental;

public class Garage {
    private Vehicle vehicle;


    /**
     * setVehicle can park a vehicle in the garage.
     * @param vehicle is the car or truck to be parked in the garage.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Displays "Description of the parked vehicle" followed by the color of the vehicle if the garage is not empty
     * otherwise it Displays the same message with "Garage is empty" instead of the vehicle's color.
     * @return a String containing the vehicle's color is there's one in the garage, otherwise it says the garage is empty.
     */
    @Override
    public String toString() {
        if (vehicle != null) {
            return "Description of the parked vehicle: " + vehicle.toString();
        }
        return "Description of the parked vehicle: Garage is empty.";
    }
}
