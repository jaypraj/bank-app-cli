/**
 * Simple CLI Bank Application
 * Author: Jaymin Prajapati
 * Created on: 07 April 2021
 */

package org.jaypraj.bankappcli;

import org.jaypraj.bankappcli.beans.Account;
import org.jaypraj.bankappcli.beans.Bank;
import org.jaypraj.bankappcli.beans.User;
import org.jaypraj.bankappcli.util.AppUtils;

import java.util.List;
import java.util.Scanner;

public class App {

    final static Scanner scanner = new Scanner(System.in);
    static User user;
    static Account account;

    public static void main(String[] args) {
        int option;

        while (true) {
            showMenu();

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Please, select an appropriate option!");
                    break;
            }
        }
    }

    /**
     * Displays a login menu.
     */
    static void showMenu() {
        AppUtils.printLabels("Welcome to " + Bank.getName());
        System.out.println("Please select an appropriate option from below:\n" +
                "1. Register\n" +
                "2. Login\n" +
                "3. Exit");
    }

    /**
     * Creates a user, and account for that user.
     */
    static void registerUser() {
        AppUtils.printLabels("User Registration");

        System.out.print("Enter your first name: ");
        String firstName = scanner.next();
        System.out.print("Enter your last name: ");
        String lastName = scanner.next();
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User user = new User(firstName, lastName, username, password);
        Account account = Account.createAccount(user);
        user.setAccount(account);
        account.setUser(user);
        Bank.getAccounts().add(account);
        Bank.getUsers().add(user);
    }

    /**
     * Logs in user into the application.
     */
    static void login() {
        AppUtils.printLabels("User Login");

        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        List<User> users = Bank.getUsers();
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                user = u;
            }
        }

        if (user != null) {
            account = user.getAccount();
            showAccountMenu();
        } else {
            AppUtils.printLabels("ERROR: Incorrect credentials! Please try again.");
            return;
        }
    }

    /**
     * Displays an account menu to logged in user.
     */
    public static void showAccountMenu() {

        AppUtils.printLabels("Welcome, " + user.getFirstName() + " " + user.getLastName());
        while (true) {
            AppUtils.printLabels("Account Options");

            System.out.println("Please, select an appropriate option:\n" +
                    "1. Check balance\n" +
                    "2. Add money\n" +
                    "3. Withdraw money\n" +
                    "4. Delete account\n" +
                    "5. Exit");

            int option = scanner.nextInt();
            double amount;

            switch (option) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.println("Please enter an amount to add: ");
                    amount = scanner.nextDouble();
                    account.credit(amount);
                    break;
                case 3:
                    System.out.println("Please enter an amount to withdraw: ");
                    amount = scanner.nextDouble();
                    account.debit(amount);
                    break;
                case 4:
                    System.out.print("Are you sure you want delete your account? (y|n): ");

                    if (scanner.next().toLowerCase().equals("y")) {
                        account.deleteAccount();
                        user = null;
                        account = null;
                    }
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Please select an appropriate option!");
                    break;
            }
        }
    }
}
