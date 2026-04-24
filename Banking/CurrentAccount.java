public class CurrentAccount extends Account {

    double minimumBalance = 1000;

    public CurrentAccount(int accountNumber, double balance, customer customer) {
        super(accountNumber, balance, customer);
    }

    public void checkMinimumBalance() {

        if(balance < minimumBalance)
            System.out.println("Minimum balance not maintained");
        else
            System.out.println("Minimum balance maintained");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");

        balance -= amount;
        System.out.println("Current Account Withdrawal: " + amount);
    }
}