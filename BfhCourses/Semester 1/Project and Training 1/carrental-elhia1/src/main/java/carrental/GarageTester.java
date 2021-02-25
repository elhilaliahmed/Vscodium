/*
 * Project and Training 1 - HS20/21 (Java), Computer Science, Berner
 * Fachhochschule
 */

package carrental;

public class GarageTester {

	public static Garage getExample() {
		Garage garage = new Garage();
		Truck truck = new Truck("black", false);
		garage.setVehicle(truck);
		return garage;
	}

	public static void main(String[] args) {
		Garage garage = getExample();
	}

}
