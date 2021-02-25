# Patients with medical Checkups

## Checkup Class

Write a class `Checkup`. This class has the following instance variables: an integer that stores the height in cm, a double that stores the weight in kg, a double that stores the temperature and a boolean that indicates whether the vaccination state of the patient is ok or not.

Define a constructor with the following signature:

- `public Checkup(int height, double weight, double temperature, boolean vaccsok)`

Define getter methods with the following signatures:

- `public int getHeight()`
- `public double getWeight()`
- `public double getTemperature()`
- `public boolean getVaccsOk()`

_@Kotlin: The constructor and getter are created implicitly, when (read-only) properties are used. 
Just map the `vaccinationsUpToDate` property from the constructor to a second property `vaccsOk` to get the correct `getVaccsOk()` function._
## Patient Class

Define a class `Patient` with an instance variable name of type `String`. Define a constructor to set the name for the patient. Define a method with the following signature:

- `public void addCheckup(int height, double weight, double temp, boolean vaccs)`

Define a toString method that returns a String containing all the relevant information about the patient.

Example:
`Name: Jim Smith,Height: 180,Weight: 80.0,Temperature: 36.5`

