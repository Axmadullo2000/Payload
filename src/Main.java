import exceptions.AmountLimitExceededException;
import exceptions.InsufficientBalanceException;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final BankAccount bankAccount = new BankAccount(1000);

    public static void main(String[] args) {

        start(bankAccount);

        System.out.println("Program has finished!!!");
    }

    public static void start(BankAccount bankAccount) {
        while (true) {
            System.out.println("""
                1. Make a withdrawal
                2. Top up the balance
                3. Show balance
                0. Quit
                """);
            int option = input.nextInt();

            switch (option) {
                case 1 -> {
                    withdraw(bankAccount);
                }

                case 2 -> {
                    topUpBalance(bankAccount);
                }

                case 3 -> {
                    showBalance();
                }

                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void withdraw(BankAccount bankAccount) {
        System.out.print("How much would you like to withdraw from the card?");
        double amount = input.nextDouble();

        try {
            bankAccount.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void topUpBalance(BankAccount bankAccount) {
        System.out.print("How much would you like to top up your card? ");
        double amount = input.nextDouble();

        try {
            bankAccount.topUpBalance(amount);
        }catch (AmountLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showBalance() {
        System.out.println("Your current balance: " + bankAccount.getBalance());
    }
}
