public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    // Constructor with balance and interest rate
    public SavingsAccount(double balance, double interestRate) {
        super(balance); // Call the CheckingAccount constructor
        this.interestRate = interestRate;
    }

    // Method to calculate interest and update the balance
    public void calcInterest() {
        double interest = getBalance() * interestRate / 100;
        double newBalance = getBalance() + interest;
        setBalance(newBalance);
        System.out.println("Interest calculated. New Balance: " + getBalanceString());
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Menu method specific to SavingsAccount
    @Override
    public String menu() {
        return "0) Quit\n1) Check Balance\n2) Calculate Interest";
    }

    // Start method to handle user input
    @Override
    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println(menu());
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    checkBalance();
                    break;
                case 2:
                    calcInterest();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000.00, 5.0); // Test with initial balance of 1000.00 and interest rate of 5%
        savingsAccount.start();
    }
}
