// Program 4: BankAccount Class with Deposit, Withdraw and Balance Inquiry

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber  = accountNumber;
        this.balance        = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("   Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("   Deposited %.2f  |  New Balance: %.2f%n", amount, balance);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("   Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.printf("   Insufficient funds. Available: %.2f%n", balance);
            return;
        }
        balance -= amount;
        System.out.printf("   Withdrew ₹%.2f  |  Remaining Balance: %.2f%n", amount, balance);
    }

    // Balance inquiry
    public void checkBalance() {
        System.out.printf("  Account: %s | Holder: %s | Balance: %.2f%n",
                accountNumber, accountHolder, balance);
    }

    public static void main(String[] args) {
        System.out.println("====== BankAccount Demo ======\n");

        BankAccount acc = new BankAccount("Arjun Mehta", "SB-1001", 5000.00);

        System.out.println("Initial Balance:");
        acc.checkBalance();

        System.out.println("\nDepositing ₹3000:");
        acc.deposit(3000);

        System.out.println("\nWithdrawing ₹2000:");
        acc.withdraw(2000);

        System.out.println("\nWithdrawing ₹10000 (insufficient funds):");
        acc.withdraw(10000);

        System.out.println("\nTrying negative deposit:");
        acc.deposit(-500);

        System.out.println("\nFinal Balance:");
        acc.checkBalance();
    }
}