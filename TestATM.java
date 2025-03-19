public class TestATM {
    public static void main(String[] args) {
        // Create a new customer with userName "Alice" and PIN "0000"
        Customer customer = new Customer("Alice", "0000", 0.0, 0.0, 5.0);

        // Simulate the customer starting the program and interacting with the menu
        customer.start();
    }
}
