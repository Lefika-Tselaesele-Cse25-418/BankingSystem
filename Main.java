
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
            "Thato",
            "Molefe",
            "Palapye, Botswana",
            true
        );

        SavingsAccount savings = new SavingsAccount(
            "S001", "Palapye", customer);

        InvestmentAccount investment = new InvestmentAccount(
            "I001", "Palapye", customer, 500.00);

        ChequeAccount cheque = new ChequeAccount(
            "C001", "Palapye", customer,
            "ABC Company", "Palapye, Botswana");

        customer.openAccount(savings);
        customer.openAccount(investment);
        customer.openAccount(cheque);

        savings.deposit(1000.00);
        investment.deposit(200.00);
        cheque.deposit(300.00);

        savings.calculateMonthlyInterest();
        investment.calculateMonthlyInterest();

        System.out.println("Customer: "
            + customer.getFirstName() + " "
            + customer.getSurname());

        System.out.println("\nCustomer Accounts:");

        for (Account account : customer.getAccounts()) {
            System.out.println(account);
        }
    }
}
