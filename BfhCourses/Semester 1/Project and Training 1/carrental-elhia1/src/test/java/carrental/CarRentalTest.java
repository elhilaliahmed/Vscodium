package carrental;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {

    private final Truck green = new Truck("green");
    private final Truck blue = new Truck("blue", true);
    private final Car red = new Car("red");
    private final Car yellow = new Car("yellow", true);
    private final Customer c1 = new Customer("Anna Smith", "Biel/Bienne");
    private final Customer c2 = new Customer("Bill Bob", "Bern");
    private final CarRental cars = new CarRental();


    @Test
    void testTruck() {
        assertEquals("This vehicle is green, has Trailer: false", green.toString());
        assertEquals("This vehicle is blue, has Trailer: true",
                blue.toString());
    }

    @Test
    void   testTruckSetter() {
        assertThrows(NoSuchMethodException.class,
                () -> Truck.class.getMethod("setTrailer", boolean.class),
                "Class Truck shouldn't have a public method " +
                "setTrailer(boolean b)");
    }

    @Test
    void testCar() {
        assertEquals("This vehicle is red, has WinterTires: false", red.toString());
        assertEquals("This vehicle is yellow, has WinterTires: true",
                yellow.toString());
    }

    @Test
    void testCarSetter() {
        assertThrows(NoSuchMethodException.class,
                () -> Car.class.getMethod("setTires", boolean.class),
                "Class Car shouldn't have a public method " +
                "setTires(boolean b)");
    }

    @Test
    void testGarage() {
        Garage gar = new Garage();
        gar.setVehicle(red);
        assertEquals("Description of the parked vehicle: This vehicle is red, has WinterTires: false", gar.toString());
    }

    @Test
    void testGarageTester() {
        Garage expected = new Garage();
        Truck myTruck = new Truck("black", false);
        // empty garage
		assertEquals("Description of the parked vehicle: Garage is empty.",
                expected.toString());
		// truck in garage
        expected.setVehicle(myTruck);
        Garage g = GarageTester.getExample();
        assertEquals(expected.toString(), g.toString());
    }

    @Test
    void testCarRentalContract() {
        CarRentalContract con1 = new CarRentalContract(c1, blue);
        assertEquals("Anna Smith[Biel/Bienne]:This vehicle is blue, has " +
                        "Trailer: true",
				con1.toString());
    }

    @Test
    void testCarRental() {
        CarRentalContract con1 = new CarRentalContract(c1, blue);
        CarRentalContract con2 = new CarRentalContract(c2, green);
        cars.addContract(con1);
        cars.addContract(con2);
        assertEquals("Anna Smith[Biel/Bienne]:This vehicle is blue, has Trailer: true",
				cars.displayContracts().split("\n")[0]);
        assertEquals("Bill Bob[Bern]:This vehicle is green, has Trailer: false",
				cars.displayContracts().split("\n")[1]);
    }

    @Test
    void testCarRentalContractSetter() {
        assertThrows(NoSuchMethodException.class,
                () -> CarRentalContract.class.getMethod("setCustomer",
                        Customer.class),
                "Class CarRentalContract shouldn't have a public method " +
                        "setCustomer(Customer c)");
        assertThrows(NoSuchMethodException.class,
                () -> CarRentalContract.class.getMethod("setVehicle",
                        Vehicle.class),
                "Class CarRentalContract shouldn't have a public method " +
                        "setVehicle(Vehicle c)");
    }


    @Test
    void testVehicleAbstract() {
        // Vehicle class must be abstract
        assertTrue(Modifier.isAbstract( Vehicle.class.getModifiers()));
    }

}
