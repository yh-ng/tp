package seedu.duke.task;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Renamed from previous Task.java with some modifications.
/**
 * Represents an item in the list.
 */
public class Item implements Comparable<Item> {
    public static DateTimeFormatter DATETIME_PARSE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static DateTimeFormatter DATETIME_PRINT_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    protected String description;
    protected boolean isDone;
    protected int priority;
    protected String category;
    protected LocalDate date;
    protected LocalDate futureDate;

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the task
     */
    public Item(String description) {
        this.description = description;
        this.isDone = false;
        this.setPriority(0);
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the task
     * @param isDone true if the task is done already, false otherwise
     * @param priority the priority of the task
     */
    public Item(String description, boolean isDone, int priority) {
        this.description = description;
        this.isDone = isDone;
        this.priority = priority;
    }

    public Item(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Retrieves the description of a task.
     *
     * @return the description string of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves whether the task in done.
     *
     * @return true if the task is done already, false otherwise
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Converts the attributes of the task into a formatted string to be saved into the storage file.
     *
     * @return the formatted string to be saved into the storage file
     */
    public String toFile() {
        String isDoneString = (isDone) ? "1" : "0";
        String categoryString = (category == null) ? "" : category;
        String dateString = getDateString(Item.DATETIME_PARSE_FORMAT);
        return "T | " + isDoneString + " | " + description + " | " + priority + " | " + categoryString + " | "
                + dateString;
    }

    public String toFileBook() {
        String isDoneString = (isDone) ? "1" : "0";
        String dateString = getDateString(Item.DATETIME_PARSE_FORMAT);
        String futureDateString = getFutureDateString(Item.DATETIME_PARSE_FORMAT);

        return "B | " + isDoneString + " | " + description + " | " + dateString + " | " + futureDateString;
    }

    /**
     * Converts the attributes of the task into a formatted string to be displayed to the user.
     *
     * @return the formatted string to be displayed to the user
     */
    public String toString() {
        String returnString = "";
        if (this.isDone) {
            returnString =  "[T][Y] " + this.description + " (p:" + this.getPriority() + ")";
        } else {
            returnString =  "[T][N] " + this.description + " (p:" + this.getPriority() + ")";
        }
        if (category != null) {
            returnString += " (category: " + category + ")";
        }
        if (date != null) {
            returnString += " (date: " + getDateString(Item.DATETIME_PRINT_FORMAT) + ")";
        }
        return returnString;
    }

    /**
     * Converts the attributes of the book into a formatted string to be displayed to the user.
     *
     * @return the formatted string to be displayed to the user
     */
    public String toStringBook() {
        String returnString = "";
        returnString = description + "\n";
        if (date != null) {
            returnString += "\t\t (Loan Date: " + getDateString(Task.DATETIME_PRINT_FORMAT) + ")\n";
            returnString += "\t\t (Due Date: " + getFutureDateString(Task.DATETIME_PRINT_FORMAT) + ")";
        }
        return returnString;
    }

    /**
     * Retrieves the priority of a task.
     *
     * @return Priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Retrieves the category of a task.
     *
     * @return Category of the task.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the priority of a task.
     *
     * @param priority New priority of the task.
     */
    public void setPriority(int priority) {
        assert priority >= 0 : "Priority should be non-negative";
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDateFromString(String dateString) throws DukeException {
        assert dateString != null : "dateString should not be null.";
        try {
            date = LocalDate.parse(dateString, DATETIME_PARSE_FORMAT);
            futureDate = date.plusMonths(1);
        } catch (DateTimeParseException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDateString(DateTimeFormatter formatter) {
        if (date == null) {
            return "";
        }

        return date.format(formatter);
    }

    public String getFutureDateString(DateTimeFormatter formatter) {
        if (futureDate == null) {
            return "";
        }

        return futureDate.format(formatter);

    }

    /**
     * Defines how tasks are sorted. First sort tasks based on priority in ascending order (priority 0, i.e. no
     * priority, is the last). If two tasks have the same priority, sort based on category lexicographically.
     *
     * @param otherItem The other task to compare to.
     * @return negative integer if this task precedes the argument task,
     *     positive integer if this task follows the argument task, 0 otherwise.
     */
    @Override
    public int compareTo(Item otherItem) {
        if (this.priority != otherItem.priority && this.priority == 0) {
            return 1;
        }
        if (this.priority != otherItem.priority && otherItem.priority == 0) {
            return -1;
        }
        if (this.priority != otherItem.priority) {
            return this.priority - otherItem.priority;
        }
        String thisItemCategory = (this.category == null) ? "" : this.category;
        String otherItemCategory = (otherItem.category == null) ? "" : otherItem.category;
        return thisItemCategory.compareTo(otherItemCategory);
    }
}
