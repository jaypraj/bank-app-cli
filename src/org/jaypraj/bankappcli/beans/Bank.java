package org.jaypraj.bankappcli.beans;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final static String name = "SecureBank Ltd.";
    private static List<User> users = new ArrayList<>();
    private static List<Account> accounts = new ArrayList<>();

    // Used to create new account numbers
    private static Long lastAccount = 0L;

    public static String getName() {
        return name;
    }

    public static Long getLastAccount() {
        return lastAccount;
    }

    public static void setLastAccount(Long lastAccount) {
        Bank.lastAccount = lastAccount;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Account> getAccounts() {
        return accounts;
    }
}
