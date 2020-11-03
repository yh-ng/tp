package seedu.duke.ui;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.item.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
     * Prints a calendar from a given task list.
     *
     * @param currentDate Date of the current day.
     * @param taskList ArrayList of Task to print the tasks from.
     * @param daysToPrint Number of days of tasks being printed.
     */
    public static void dukePrintCalendar(LocalDate currentDate, ArrayList<Task> taskList, int daysToPrint) {
        assert daysToPrint >= 0 : "Days should be a positive integer";
        showLine();
        dukePrintCalendarHeading(currentDate, taskList, daysToPrint);
        dukePrintCalendarTasks(taskList);
        showLine();
    }

    /**
     * Prints the heading of the calendar.
     *
     * @param date Date to be printed in the heading.
     * @param taskList ArrayList of Task to print the tasks from.
     * @param daysToPrint Number of days of tasks being printed.
     */
    private static void dukePrintCalendarHeading(LocalDate date, ArrayList<Task> taskList, int daysToPrint) {
        if (taskList.size() <= 0) {
            dukePrintMultiple("You have no tasks for the next " + daysToPrint + " day(s).");
            return;
        }
        dukePrintMultiple("Today's date is: " + date.format(Task.DATETIME_PRINT_FORMAT));
        dukePrintMultiple("Here's your tasks for the next " + daysToPrint + " day(s).");
        showLine();
    }

    /**
     * Prints the tasks in the calendar.
     *
     * @param taskList ArrayList of Task to print the tasks from.
     */
    private static void dukePrintCalendarTasks(ArrayList<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);

            if (i == 0) {
                dukePrintDayHeading(task.getDate());
                dukePrintMultiple(task.toString());
                continue;
            }

            LocalDate previousTaskDate = taskList.get(i - 1).getDate();
            if (task.getDate().compareTo(previousTaskDate) != 0) {
                showLine();
                dukePrintDayHeading(task.getDate());
            }
            dukePrintMultiple(task.toString());
        }
    }

    /**
     * Prints the heading in the calendar for a certain date.
     *
     * @param date Date of the heading.
     */
    private static void dukePrintDayHeading(LocalDate date) {
        dukePrintMultiple(date.getDayOfWeek().toString() + " - " + date.format(Task.DATETIME_PRINT_FORMAT));
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
