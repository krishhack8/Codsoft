import java.util.Scanner;

// Class to represent user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit amount in the account.
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw amount from the account.
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class to represent ATM Interface
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    // Method to displaying options to a user.
    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner scanner= new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();

            atm.processOption(option, scanner);
        }
    }
}