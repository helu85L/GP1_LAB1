public class Calculator {
    
    public static double calculateConsumption(int wattage, int usage, int quantity, String usageType) {
        double consumption = 0; 
        if (usageType.equalsIgnoreCase("day")) {
            consumption = (wattage * quantity * usage * 30) / 1000.0;
        } else if (usageType.equalsIgnoreCase("month")) {
            consumption = (wattage * quantity * usage) / 1000.0;
        }
        return consumption;
    }

  
    public static double calculateBillAmount(double totalConsumption) {
        double ratePerKWh = 2.50; // Example rate per kWh in ETB
        return totalConsumption * ratePerKWh;
    }

  
    public static double calculateServiceCharge(double amount) {
        double serviceCharge = 42.00; // Example service charge in ETB
        return serviceCharge;
    }


    public static double calculateTotalBill(double amount, double serviceCharge) {
        return amount + serviceCharge;
    }
}
