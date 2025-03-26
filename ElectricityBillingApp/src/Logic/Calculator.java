package Logic;

public class Calculator {
    public static double calculateBill(double units) {
        double rate;
        if (units <= 100) {
            rate = 0.273;  // ETB per unit (example: Update as per Ethiopian electricity tariff)
        } else if (units <= 300) {
            rate = 0.450;  // ETB per unit
        } else {
            rate = 0.750;  // ETB per unit
        }
        return units * rate;
    }
}
