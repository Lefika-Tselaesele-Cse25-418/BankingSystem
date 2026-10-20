
public class ChequeAccount extends Account {
    private String companyName;
    private String companyAddress;

    public ChequeAccount(String accountNumber,
                         String branch,
                         Customer customer,
                         String companyName,
                         String companyAddress) {
        super(accountNumber, 0.0, branch, customer);

        if (!customer.isEmployed()) {
            throw new IllegalArgumentException(
                "Cheque accounts require an employed customer");
        }

        if (companyName == null || companyName.isBlank()
                || companyAddress == null
                || companyAddress.isBlank()) {
            throw new IllegalArgumentException(
                "Company name and address are required");
        }

        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    @Override
    public void withdraw(double amount) {
        deduct(amount);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    @Override
    public String toString() {
        return "Cheque " + super.toString()
            + ", Company: " + companyName;
    }
}
