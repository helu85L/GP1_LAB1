public class Calculator {
    
    public static double calculateConsumption(int wattage, int usage, int quantity) {
        return (wattage * quantity * usage) / 1000.0; 
    }

    
    public static double calculateBillAmount(double totalConsumption) {
        double ratePerKWh = 2.50; 
        return totalConsumption * ratePerKWh;
    }

 
    public static double calculateServiceCharge(double amount) {
        double serviceCharge = 42.00; 
        return serviceCharge;
    }

   
    public static double calculateTotalBill(double amount, double serviceCharge) {
        return amount + serviceCharge;
    }
}
