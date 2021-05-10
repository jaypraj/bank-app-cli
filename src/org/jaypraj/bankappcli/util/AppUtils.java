package org.jaypraj.bankappcli.util;

/**
 * Utility class
 */
public class AppUtils {
    /**
     * Utility method used to print labels in proper format on the console.
     *
     * @param label Message to be displayed inside the label
     */
    public static void printLabels(String label) {
        for (int i = 0; i < label.length() + 4; i++) {
            System.out.print("=");
        }
        printIntermediate(label);
        System.out.print("| ");
        System.out.print(label);
        System.out.print(" |");
        printIntermediate(label);
        for (int i = 0; i < label.length() + 4; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * Extracted helper method for the print method
     *
     * @param label
     */
    private static void printIntermediate(String label) {
        System.out.println();
        System.out.print("|");
        for (int i = 0; i < label.length() + 2; i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }
}
