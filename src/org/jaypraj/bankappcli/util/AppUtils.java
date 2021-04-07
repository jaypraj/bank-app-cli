package org.jaypraj.bankappcli.util;

/**
 * Utility class
 */
public class AppUtils {
    /**
     * Utility method used to print labels in proper format on the console.
     * @param message Message to be displayed inside the label
     */
    public static void print(String message) {
        for (int i = 0; i < message.length() + 4; i++) {
            System.out.print("=");
        }
        printLabels(message);
        System.out.print("| ");
        System.out.print(message);
        System.out.print(" |");
        printLabels(message);
        for (int i = 0; i < message.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * Extracted helper method for the print method
     * @param message
     */
    private static void printLabels(String message) {
        System.out.println();
        System.out.print("|");
        for (int i = 0; i < message.length() + 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }
}
