
public abstract class Account {
    private String accountNumber;
    private double balance;
    private String branch;
    private Customer customer;

    public Account(String accountNumber, double balance,
                   String branch, Customer customer) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                "Account number is required");
        }

        if (balance < 0 || !Double.isFinite(balance)) {
            throw new IllegalArgumentException(
                "Invalid balance");
        }

        if (customer == null) {
            throw new IllegalArgumentException(
                "An account must have a customer");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
        this.customer = customer;
    }

    public void deposit(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            throw new IllegalArgumentException(
                "Deposit must be positive");
        }

        balance += amount;
    }

    public abstract void withdraw(double amount);

    protected void deduct(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient funds");
        }

        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber
            + ", Balance: BWP " + String.format("%.2f", balance)
            + ", Branch: " + branch;
    }
}
