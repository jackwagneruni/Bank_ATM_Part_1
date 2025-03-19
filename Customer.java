public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        checking = new CheckingAccount();
        savings = new SavingsAccount(0, 0.02); // Assuming a default interest rate
    }

    public Customer(String userName, String PIN) {
        this();
        setUserName(userName);
        setPIN(PIN);
    }

    public String menu() {
        return "Customer Menu\n" +
               "0) Exit\n" +
               "1) Manage Checking Account\n" +
               "2) Manage Savings Account\n" +
               "3) change PIN";
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(menu());
            int choice = getChoice();
    
            if (choice == 0) {
                running = false;
            } else if (choice == 1) {
                checking.start();
            } else if (choice == 2) {
                savings.start();
            } else if (choice == 3) {
                changePin();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    

    private int getChoice() {
        // Replace with actual code for getting user input
        return 1; // Temporary stub for compilation
    }

    private void changePin() {
        System.out.println("Changing PIN...");
        // Implement PIN change logic here
    }

    public String getReport() {
        return "Customer Report: " + getUserName() + " checking balance: " + checking.getBalance();
    }
    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "1111");
        if (customer.login()) {
            System.out.println("Login Successful");
            customer.start();
        } else {
            System.out.println("Login Failed");
        }
    }
}
