package org.jaypraj.bankappcli.beans;

import org.jaypraj.bankappcli.util.AppUtils;

public class Account {
    private Long accountNumber;
    private User user;
    private Double balance;

    /**
     * Creates a new account, sets the user of account and initial balance as 0
     *
     * @param user Owner of the account
     * @return account instance
     */
    public static Account createAccount(User user) {
        Account account = new Account();
        long accountNumber = Bank.getLastAccount() + 1;
        account.setAccountNumber(accountNumber);
        account.setUser(user);
        account.setBalance(0D);
        Bank.setLastAccount(accountNumber);
        AppUtils.printLabels("CREATED: Account created successfully! (Account number: " + accountNumber + ")");
        return account;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("accountNumber=").append(accountNumber);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Deposits money to the account
     *
     * @param amount Amount to be deposited
     */
    public void credit(double amount) {
        if (amount > 0) {
            this.setBalance(this.getBalance() + amount);
            AppUtils.printLabels("CREDIT: $" + amount + " credited. (BALANCE: $" + this.getBalance() + ")");
        }
    }

    /**
     * Withdraws amount from the account
     *
     * @param amount Amount to be withdrawn
     */
    public void debit(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.setBalance(this.getBalance() - amount);
            AppUtils.printLabels("DEBIT: $" + amount + " debited. (BALANCE: $" + this.getBalance() + ")");
        } else {
            AppUtils.printLabels("ERROR: Insufficient balance (BALANCE: $" + this.getBalance() + ")");
        }
    }

    /**
     * Checks account balance
     */
    public void checkBalance() {
        AppUtils.printLabels("BALANCE: $" + this.getBalance());
    }

    public void deleteAccount() {
        Bank.getAccounts().remove(this);
        Bank.getUsers().remove(this.user);

        AppUtils.printLabels("DELETED: Account deleted successfully.");
    }
}
