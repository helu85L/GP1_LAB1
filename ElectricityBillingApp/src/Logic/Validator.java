package Logic;

public class Validator {
    public static boolean isValidNumber(String input) {
        try {
            double value = Double.parseDouble(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
