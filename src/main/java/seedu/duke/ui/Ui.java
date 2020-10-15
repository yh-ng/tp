package seedu.duke.ui;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Shows the divider line.
     */
    public static void showLine() {
        System.out.println(Messages.DIVIDER);
    }

    /**
     * Prints messages to the user in a structured format.
     *
     * @param message the messaged to be printed
     */
    public static void dukePrint(String message) {
        showLine();
        System.out.println("     " + message);
        showLine();
        System.out.println();
    }

    public static void dukePrintMultiple(String message) {
        System.out.println("     " + message);
    }

    /**
     * Generates and prints the welcome message upon the start of the application.
     */
    public static void showWelcome() {
        System.out.println(Messages.LOGO);
        dukePrint("Hello! I'm termiNus.\n     What can I do for you?");
    }

    /**
     * Prints the goodbye message after the termination of the application.
     */
    public static void exit() {
        dukePrint(Messages.MESSAGE_GOODBYE);
    }

    /**
     * Reads user input.
     */
    public static String readCommand() {
        return sc.nextLine();
    }

    /**
     * Prints the error message to the user if an error occurs.
     * @param e the {@code DukeException} representing the error occurred
     */
    public static void showError(DukeException e) {
        dukePrint(e.getMessage());
    }

    /**
     * Formats the date time from user input.
     *
     * @param time the date time from user input
     * @return the formatted date time string
     * @throws DateTimeParseException if the user input date time is not in the specified format
     */
    public static String formatDateTime(String time) throws DateTimeParseException {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyy HH:mm");
        LocalDateTime formattedDateTime = LocalDateTime.parse(time, inputFormatter);
        String returnString = formattedDateTime.format(outputFormatter);
        return returnString;
    }
}
