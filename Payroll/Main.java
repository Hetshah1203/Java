public class Main {
    public static void main(String[] args) {

        try {
            Employee ft1 = new FullTimeEmployee(
                    "Amit", "PAN123", "01-01-2022", "SWE",
                    101, 300000, 100000, 40000, 0, "SWE"
            );

            Employee ct1 = new ContractEmployee(
                    "Ravi", "PAN456", "05-03-2023", "Contract",
                    102, 100, 50
            );

            Employee m1 = new Manager(
                    "Neha", "PAN789", "10-06-2020", "Manager",
                    103, 500000, 120000, 80000, 20000,
                    30000, 20000
            );

            Employee[] empList = {ft1, ct1, m1};

            System.out.println("EmpType\tBaseSal\tHealthIns\tBonus\tOptions\tCTC");

            for (Employee e : empList) {
                System.out.println(
                        e.getEmployeeType() + "\t" +
                        e.getBaseSalary() + "\t" +
                        e.getHealthIns() + "\t\t" +
                        e.getBonus() + "\t" +
                        e.getOptions() + "\t" +
                        e.calcCTC()
                );
            }

        } catch (InvalidEmployeeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }
    }
}