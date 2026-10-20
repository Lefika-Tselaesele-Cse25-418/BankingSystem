
public class SavingsAccount extends Account
        implements InterestBearing {

    private static final double MONTHLY_RATE = 0.0005;

    public SavingsAccount(String accountNumber, String branch,
                          Customer customer) {
        super(accountNumber, 0.0, branch, customer);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException(
            "Withdrawals are not allowed on savings accounts");
    }

    @Override
    public void calculateMonthlyInterest() {
        deposit(getBalance() * MONTHLY_RATE);
    }

    @Override
    public String toString() {
        return "Savings " + super.toString();
    }
}
