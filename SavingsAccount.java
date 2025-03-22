import java.util.Scanner;

public class SavingsAccount {
    private double balance;
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public String menu() {
        return "0) Quit\n1) Check Balance\n2) Make a Deposit\n3) Make a Withdrawal\nPlease enter 0-3:";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println(menu());
            int choice = scanner.nextInt();

            if (choice == 0) {
                exit = true;
            } else if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                System.out.print("How much to deposit? ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
            } else if (choice == 3) {
                System.out.print("How much to withdraw? ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000.00, 0.02);
        savingsAccount.start();
    }
}
