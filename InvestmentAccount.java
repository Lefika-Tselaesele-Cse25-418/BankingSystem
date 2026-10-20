
public class InvestmentAccount extends Account
        implements InterestBearing {

    private static final double MONTHLY_RATE = 0.05;

    public InvestmentAccount(String accountNumber,
                             String branch,
                             Customer customer,
                             double initialDeposit) {
        super(accountNumber, initialDeposit, branch, customer);

        if (initialDeposit < 500) {
            throw new IllegalArgumentException(
                "Investment account requires at least BWP 500");
        }
    }

    @Override
    public void withdraw(double amount) {
        deduct(amount);
    }

    @Override
    public void calculateMonthlyInterest() {
        deposit(getBalance() * MONTHLY_RATE);
    }

    @Override
    public String toString() {
        return "Investment " + super.toString();
    }
}
