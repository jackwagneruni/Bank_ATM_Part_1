# Bank-On-It

public static void main(String[] args) {

}

interface HasMenu 
  string menu()
  void start()


  class CheckingAccount implements HasMenu

    double balance

    CheckingAccount()
    CheckingAccount(double balance)
    main()
    string menu()
    void start()   
    double getBalance()
    string getBalanceString()
    void setBalance(double balance)
    void checkBalance()
    private double getDouble()
    void makeDeposit()
    void makeWithdrawal()


class SavingsAccount extends CheckingAccount

    double interestRate

    main()
    calcInterest()
    void setInterestRate()
    double getInterestRate()


abstract class User implements HasMenu, Serializable

    string userName
    string PIN

    boolean login()
    boolean login(userName, PIN)
    void setUserName(userName)
    string getUserName()
    void setPIN(PIN)
    string getPIN()
    abstract string getReport()


class Customer extends User

    CheckingAccount checking 
    SavingsAccount savings 

    void main()
    Customer()
    Customer(usernName, PIN)
    void start()
    string menu()
    void changePin()
    string getReport()


##END WEEK ONE


##BEGIN WEEK TWO


class Admin extends User

    Admin()
    string menu()
    void start()
    string getReport()


    class Bank implements HasMenu

    Admin admin
    ArrayList customers

    Bank()
    void main()
    void loadSampleCustomers()
    void saveCustomers()
    void loadCustomers()
    void reportAllUsers()
    void addUser()
    void applyInterest()
    void loginAsCustomer()
    string menu()
    void start()
    void startAdmin()


