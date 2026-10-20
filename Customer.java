
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String surname;
    private String address;
    private boolean employed;
    private List<Account> accounts;

    public Customer(String firstName, String surname,
                    String address, boolean employed) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.employed = employed;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException(
                "Account cannot be null");
        }

        if (account.getCustomer() != this) {
            throw new IllegalArgumentException(
                "Account belongs to another customer");
        }

        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public boolean isEmployed() {
        return employed;
    }

    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }
}
