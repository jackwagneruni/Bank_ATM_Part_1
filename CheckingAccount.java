import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;
    private Scanner scanner;

    // Constructor with no initial balance
    public CheckingAccount() {
        this.balance = 0.0;
        this.scanner = new Scanner(System.in); // Initialize scanner here
    }

    // Constructor with initial balance
    public CheckingAccount(double balance) {
        this.balance = balance;
        this.scanner = new Scanner(System.in); // Initialize scanner here
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Special getter to return balance as a formatted string
    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    // Method to check balance (prints balance)
    public void checkBalance() {
        System.out.println("Current Balance: " + getBalanceString());
    }

    // Method to make a deposit
    public void makeDeposit() {
        double deposit = getDouble();
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Deposit Successful. New Balance: " + getBalanceString());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to make a withdrawal
    public void makeWithdrawal() {
        double withdrawal = getDouble();
        if (withdrawal > 0 && withdrawal <= balance) {
            balance -= withdrawal;
            System.out.println("Withdrawal Successful. New Balance: " + getBalanceString());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Convenience method to read a double input from the user with error handling
    private double getDouble() {
        double value = 0;
        try {
            value = scanner.nextDouble();
            scanner.nextLine(); // Consume newline after number input
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine(); // Consume invalid input
        }
        return value;
    }

    // Menu method to display options
    @Override
    public String menu() {
        return "0) Quit\n1) Check Balance\n2) Make Deposit\n3) Make Withdrawal";
    }

    // Start method to handle user input
    @Override
    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println(menu());
            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline after number input
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
            
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(100.00); // Test with initial balance of 100.00
        account.start();
    }
}
