import exceptions.AmountLimitExceededException;
import exceptions.InsufficientBalanceException;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount * 1.07 > balance) {
            throw new InsufficientBalanceException("Insufficient funds for the transaction!");
        }else {
            balance -= amount * 1.05;
            System.out.println("Money withdrawn successfully! Remaining balance: " + balance);
        }
    }

    public void topUpBalance(double amount) throws AmountLimitExceededException {
        if (amount > Math.pow(10, 8)) {
            throw new AmountLimitExceededException("Limit exceeded. The maximum allowed amount is 10 million.");
        }else {
            balance += amount * 0.95;
            System.out.println("After 5% fee, balance has been topped up! New balance: " + balance);
        }
    }

}
