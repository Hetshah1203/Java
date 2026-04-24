import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            ArrayList<customer> customers = new ArrayList<>();
            
            customer c1 = new customer(
                    "085",
                    "Kavish",
                    "Nag",
                    "kavishnag13@gmail.com",
                    "9829326907",
                    "Pune",
                    "12345678910",
                    "ABCDEFGHIJK"
            );
            
            customer c2 = new customer(
                    "086",
                    "Jeff",
                    "Sharma",
                    "jeff.sharma@gmail.com",
                    "9876543210",
                    "Mumbai",
                    "98765432109",
                    "XYZABCDEFGH"
            );
            
            customer c3 = new customer(
                    "087",
                    "Tony",
                    "Stank",
                    "iron.man@gmail.com",
                    "9123456789",
                    "Delhi",
                    "12341234123",
                    "PQRSTUVWXYZ"
            );
            
            customers.add(c1);
            customers.add(c2);
            customers.add(c3);
            
            ArrayList<Account> accounts = new ArrayList<>();
            
            SavingsAccount sa1 = new SavingsAccount(1001, 5000, c1);
            CurrentAccount ca1 = new CurrentAccount(2001, 10000, c1);
            accounts.add(sa1);
            accounts.add(ca1);
            
            SavingsAccount sa2 = new SavingsAccount(1002, 8000, c2);
            CurrentAccount ca2 = new CurrentAccount(2002, 15000, c2);
            accounts.add(sa2);
            accounts.add(ca2);
            
            SavingsAccount sa3 = new SavingsAccount(1003, 3000, c3);
            accounts.add(sa3);
            
            System.out.println("\n  Performing Transactions \n");
            sa1.deposit(2000);
            sa1.withdraw(1000);
            sa1.calculateInterest();
            System.out.println();
            Loan loan = new Loan(12000, 12);
            loan.displayLoan();
            loan.payEMI(sa1);
        }
        catch(InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void displayInfo(ArrayList<customer> customers, ArrayList<Account> accounts) {
        
        for(customer cust : customers) {
            System.out.println("---- CUSTOMER DETAILS ----");
            cust.displayCustomer();
            
            System.out.println("\n---- ACCOUNTS ----");
            double totalBalance = 0;
            int accountCount = 0;
            
            for(Account acc : accounts) {
                if(acc.customer.customerID.equals(cust.customerID)) {
                    System.out.println("Account Number: " + acc.accountNumber);
                    System.out.println("Account Type: " + acc.getClass().getSimpleName());
                    System.out.println("Balance: Rs. " + acc.balance);
                    totalBalance += acc.balance;
                    accountCount++;
                    System.out.println();
                }
            }

            if(accountCount > 0) {
                System.out.println("Total Accounts: " + accountCount);
                System.out.println("Total Balance Across All Accounts: Rs. " + totalBalance);
            } else {
                System.out.println("No accounts found for this customer.");
            }
        }
    }
}