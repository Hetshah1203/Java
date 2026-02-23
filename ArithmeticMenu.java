import java.util.Scanner;

public class ArithmeticMenu {

    // Method for addition
    static double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    static double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    static double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    // Method to get valid numeric input
    static double getValidNumber(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid number: ");
            sc.next(); // discard wrong input
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Menu
            System.out.println("\n===== Arithmetic Menu =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Input validation for choice
            while (!sc.hasNextInt()) {
                System.out.print("Invalid choice! Enter number (1-5): ");
                sc.next();
            }
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter first number: ");
                double num1 = getValidNumber(sc);

                System.out.print("Enter second number: ");
                double num2 = getValidNumber(sc);

                double result = 0;

                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result = " + result);
                        break;

                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result = " + result);
                        break;

                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result = " + result);
                        break;

                    case 4:
                        result = divide(num1, num2);
                        if (!Double.isNaN(result))
                            System.out.println("Result = " + result);
                        break;
                }
            }
            else if (choice != 5) {
                System.out.println("Invalid menu choice!");
            }

        } while (choice != 5);

        System.out.println("Program exited successfully.");
        sc.close();
    }
}