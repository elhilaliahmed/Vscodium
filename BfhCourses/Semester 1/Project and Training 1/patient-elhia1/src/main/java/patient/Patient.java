/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package patient;
public class Patient {
    private String name;
    private Checkup checkup;

    public Patient(String name) {
        this.name = name;
    }

    public void addCheckup(int height, double weight, double temp, boolean vaccs) {
        checkup = new Checkup(height, weight, temp, vaccs);
    }

    @Override
    public String toString() {
        return ("Name: " + name + ",Height: " + checkup.getHeight() + ",Weight: " + checkup.getWeight() + ",Temperature: " + checkup.getTemperature());
    }
}
