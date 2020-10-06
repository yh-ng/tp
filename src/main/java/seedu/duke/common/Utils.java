package seedu.duke.common;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Convert strings (either "0" or "1") to booleans (false or true respectively).
     *
     * @param str input string (either "0" or "1")
     * @return false if input string is "0", true otherwise
     */
    public static boolean stringToBoolean(String str) {
        if (str.equals("0")) {
            return false;
        }
        return true;
    }

}
