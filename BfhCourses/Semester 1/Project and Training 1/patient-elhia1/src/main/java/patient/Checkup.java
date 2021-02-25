package patient;

public class Checkup {
    private int height;
    private double weight;
    private double temperature;
    private boolean vaccsok;

    public Checkup(int height, double weight, double temperature, boolean vaccsok) {
        this.height = height;
        this.weight = weight;
        this.temperature = temperature;
        this.vaccsok = vaccsok;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean getVaccsOk() {
        return vaccsok;
    }



}
