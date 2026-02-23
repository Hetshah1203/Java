public class VehicleTest
{
    public static void main(String[] args)
    {
        // Creating objects
        Vehicle v1 = new Vehicle("Honda", "Petrol", 60, 300, 15);
        Vehicle v2 = new Vehicle("Tata", "Diesel", 55, 420, 14);
        Vehicle v3 = new Vehicle("Tesla", "Electric", 80, 500, 10);

        // Calling methods
        v1.start();
        v2.start();
        v3.start();

        v1.accelerate(20);
        v2.accelerate(15);
        v3.accelerate(25);

        v1.stop();
        v2.stop();
        v3.stop();

        // Tabular Output
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s\n",
                "Brand", "Fuel", "Speed", "Mileage");
        System.out.println("-------------------------------------------------------------");

        printVehicle(v1);
        printVehicle(v2);
        printVehicle(v3);

        System.out.println("-------------------------------------------------------------");
    }

    // Method to print table row
    public static void printVehicle(Vehicle v)
    {
        System.out.printf("%-10s %-10s %-10d %-10.2f\n",
                v.brand,
                v.fuelType,
                v.getSpeed(),
                v.calculateMileage());
    }
}