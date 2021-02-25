package callcontrol;

import java.util.function.Function;

/**
 * The PhoneNumber class provides a template to create and format phone numbers that have certain criterion, like a country number, an area code and a subscriber number.
 * @author ahmed elhilali
 */
public class PhoneNumber {
    private String countryCode;
    private String areaCode;
    private String subscriberNumber;

    /**
     * The constructor takes the countryCode, areaCode and subscriberNumber and format them in a specific way.
     * - The constructor removes the leading zeros and replaces them with a plus symbol if the latter is not present.
     * - The constructor removes any leading zeros in the area code.
     * - Insert a space after the third digit in the subscriber number if not present.
     * @param countryCode
     * @param areaCode
     * @param subscriberNumber
     */
    public PhoneNumber(String countryCode, String areaCode, String subscriberNumber) {
        this.countryCode = insertPlusSymbol.apply(removeLeadingZeros.apply(countryCode));
        this.areaCode = removeLeadingZeros.apply(areaCode);
        this.subscriberNumber = insertSpace.apply(subscriberNumber);
    }

    /**
     * The toString method return a phone number in the following format: +41 31/381 8132.
     * @return a phone number.
     */
    @Override
    public String toString() {
        return countryCode + " " + areaCode + "/" + subscriberNumber;
    }

    /**
     * The removeLeadingZeros method removes all the leading zeros in a given string.
     * @param number
     * @return a string
     */
    
    private Function<String, String> removeLeadingZeros = number ->  number.replaceAll("^0+", "");
    /**
     * The insertPlusSymbol method adds a '+' symbol in the beginning of the giving string if the symbol doesn't already exist.
     * @param number
     * @return a string
     */

    private Function<String, String> insertPlusSymbol = number -> {
        if (number.charAt(0) != '+') {
            number = "+" + (number);
        }
        return number;
    };

    /**
     * The insertSpace method insert a space after the third character in a giving string if the space doesn't already exist.
     * @param number
     * @return a string
     */

    private Function<String, String> insertSpace = number -> {
        if (number.charAt(3) != ' ') {
            number = number.substring(0,3) + " " + number.substring(3);
        }
        return number;
    };
}
