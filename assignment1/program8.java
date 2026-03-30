// Program 8: Custom Exception Handling for Bank Withdrawal Scenario

// ─── Custom Exceptions ────────────────────────────────────────────────────────

// Thrown when withdrawal amount exceeds available balance
class InsufficientFundsException extends Exception {
    private double shortfall;

    InsufficientFundsException(double shortfall) {
        super(String.format("Insufficient funds! You are short by ₹%.2f.", shortfall));
        this.shortfall = shortfall;
    }

    public double getShortfall() { return shortfall; }
}

// Thrown when withdrawal amount is invalid (zero or negative)
class InvalidAmountException extends Exception {
    InvalidAmountException(double amount) {
        super(String.format("Invalid withdrawal amount: ₹%.2f. Must be greater than 0.", amount));
    }
}

// Thrown when daily withdrawal limit is exceeded
class DailyLimitExceededException extends Exception {
    DailyLimitExceededException(double limit) {
        super(String.format("Daily withdrawal limit of ₹%.2f exceeded.", limit));
    }
}

// ─── Bank Account ─────────────────────────────────────────────────────────────

class SecureBankAccount {
    private String holder;
    private double balance;
    private double dailyLimit;
    private double withdrawnToday;

    SecureBankAccount(String holder, double balance, double dailyLimit) {
        this.holder = holder;
        this.balance = balance;
        this.dailyLimit = dailyLimit;
        this.withdrawnToday = 0;
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientFundsException,
                   DailyLimitExceededException {

        // Custom exception 1: invalid amount
        if (amount <= 0)
            throw new InvalidAmountException(amount);

        // Custom exception 2: insufficient balance
        if (amount > balance)
            throw new InsufficientFundsException(amount - balance);

        // Custom exception 3: daily limit exceeded
        if (withdrawnToday + amount > dailyLimit)
            throw new DailyLimitExceededException(dailyLimit);

        balance -= amount;
        withdrawnToday += amount;
        System.out.printf("  ✓ Withdrawn ₹%.2f | Balance: ₹%.2f | Withdrawn today: ₹%.2f%n",
                amount, balance, withdrawnToday);
    }

    public void printStatus() {
        System.out.printf("  Account: %s | Balance: ₹%.2f | Daily limit: ₹%.2f | Used today: ₹%.2f%n",
                holder, balance, dailyLimit, withdrawnToday);
    }
}

// ─── Main ─────────────────────────────────────────────────────────────────────

public class P8_CustomExceptions {

    // Helper method to attempt a withdrawal and handle exceptions cleanly
    static void tryWithdraw(SecureBankAccount acc, double amount) {
        System.out.printf("%n  → Attempting to withdraw ₹%.2f:%n", amount);
        try {
            acc.withdraw(amount);
        } catch (InvalidAmountException e) {
            System.out.println("  ✗ InvalidAmountException    : " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.printf("  ✗ InsufficientFundsException: %s (Shortfall: ₹%.2f)%n",
                    e.getMessage(), e.getShortfall());
        } catch (DailyLimitExceededException e) {
            System.out.println("  ✗ DailyLimitExceededException: " + e.getMessage());
        } finally {
            // 'finally' always runs regardless of exception
            System.out.println("  [finally] Transaction attempt logged.");
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Custom Exception Bank Demo =====\n");

        SecureBankAccount acc = new SecureBankAccount("Priya Sharma", 10000, 5000);
        System.out.print("Initial status: ");
        acc.printStatus();

        // 1. Normal withdrawal
        tryWithdraw(acc, 2000);

        // 2. Another normal withdrawal (total: 4000)
        tryWithdraw(acc, 2000);

        // 3. Exceeds daily limit (would make total 6000 > 5000)
        tryWithdraw(acc, 2000);

        // 4. Negative amount
        tryWithdraw(acc, -500);

        // 5. Exceeds balance (even if daily limit allows it)
        SecureBankAccount acc2 = new SecureBankAccount("Rahul Verma", 1000, 50000);
        System.out.println("\n  --- New account with low balance ---");
        tryWithdraw(acc2, 5000);

        System.out.println("\nFinal status:");
        acc.printStatus();
    }
}