package carrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author ahmed elhilali
 */
public class CarRental {

    List<CarRentalContract> contracts = new ArrayList<>();

    /**
     * Adding a new contract to contracts
     * @param contract is the element to be added to the array list
     */
    public void addContract(CarRentalContract contract) {
        contracts.add(contract);
    }

    /**
     * displayContracts displays all the contracts.
     * @return a String containing all the available contracts, and separating each contract with a new lin.
     */
    public String displayContracts() {
        String result = "";

        for (CarRentalContract contract: contracts) {
            result += contract.toString() + "\n";
        }
        return result;
    }
}
