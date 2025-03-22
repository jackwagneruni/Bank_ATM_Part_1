import java.util.Scanner;

public class CheckingAccount {
    private double balance;
    private Scanner scanner;

    public CheckingAccount() {
        this.balance = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
        this.scanner = new Scanner(System.in);
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
        CheckingAccount checkingAccount = new CheckingAccount(100.00);
        checkingAccount.start();
    }
}
