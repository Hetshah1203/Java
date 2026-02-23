class Vehicle
{
    // Public data members
    public String brand;
    public String fuelType;

    // Private data members
    private int speed;
    private double distance;
    private double fuelUsed;

    // Default Constructor
    Vehicle()
    {
        brand = "Unknown";
        fuelType = "Petrol";
        speed = 0;
        distance = 0;
        fuelUsed = 1;
    }

    // Parameterized Constructor
    Vehicle(String brand, String fuelType,
            int speed, double distance, double fuelUsed)
    {
        this.brand = brand;
        this.fuelType = fuelType;
        this.speed = speed;
        this.distance = distance;
        this.fuelUsed = fuelUsed;
    }

    // Getters
    public int getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public double getFuelUsed()
    {
        return fuelUsed;
    }

    // Setters
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void setFuelUsed(double fuelUsed)
    {
        this.fuelUsed = fuelUsed;
    }

    // Member Methods
    public void start()
    {
        System.out.println(brand + " vehicle started.");
    }

    public void stop()
    {
        System.out.println(brand + " vehicle stopped.");
    }

    public void accelerate(int increase)
    {
        speed += increase;
        System.out.println(brand + " accelerated to " + speed + " km/h");
    }

    // Mileage calculation
    public double calculateMileage()
    {
        return distance / fuelUsed;
    }
}