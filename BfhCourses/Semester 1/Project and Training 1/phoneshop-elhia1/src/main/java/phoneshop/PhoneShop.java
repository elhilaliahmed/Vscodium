/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package phoneshop;
public class PhoneShop {
    private String owner;
    private int phoneStock;
    private int phoneCaseStock;

    public PhoneShop (String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public int getPhoneStock() {
        return phoneStock;
    }

    public int getPhonecaseStock() {
        return phoneCaseStock;
    }

    public void fillStockPhones(int number) {
        phoneStock += number;
    }
    public void fillStockCases(int number) {
        phoneCaseStock += number;
    }

    public String phoneSold() {
        if (phoneStock > 0) {
            phoneStock--;
            return "OK";
        }
        return "NOK";
    }

    public String caseSold() {
        if (phoneCaseStock > 0) {
            phoneCaseStock--;
            return "OK";
        }
        return "NOK";
    }


}
