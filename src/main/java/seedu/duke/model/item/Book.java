package seedu.duke.model.item;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// @@author MuhammadHoze

/**
 * Represents a task in the task list.
 */
public class Book extends Item {

    protected boolean isReturn;
    protected LocalDate futureDate;

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the task
     */
    public Book(String description) {
        super(description);
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the book
     * @param isReturn    true if the book is returned already, false otherwise
     */
    public Book(String description, boolean isReturn) {
        super(description, isReturn);
        this.isReturn = isReturn;
    }

    /**
     * Marks the book as returned.
     */
    public void markAsReturn() {
        isReturn = true;
    }

    /**
     * Retrieves whether the task in done.
     *
     * @return true if the task is done already, false otherwise
     */
    public boolean getIsReturn() {
        return isReturn;
    }

    @Override
    public void setDateFromString(String dateString) throws DukeException {
        assert dateString != null : "dateString should not be null.";
        try {
            date = LocalDate.parse(dateString, DATETIME_PARSE_FORMAT);
            futureDate = date.plusMonths(1);
        } catch (DateTimeParseException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_BORROW);
        }
    }

    public String getFutureDateString(DateTimeFormatter formatter) {
        if (futureDate == null) {
            return "";
        }

        return futureDate.format(formatter);

    }

    /**
     * Converts the attributes of the book into a formatted string to be displayed to the user.
     *
     * @return the formatted string to be displayed to the user
     */
    public String toString(boolean isList) {
        String returnString = "";
        if (isList) {
            if (this.isReturn) {
                returnString = "[B][R] " + this.description + "\n";
            } else {
                returnString = "[B][L] " + this.description + "\n";
            }
        } else {
            returnString = this.description + "\n";
        }
        if (date != null) {
            returnString += "\t   (Loan Date: " + getDateString(Task.DATETIME_PRINT_FORMAT) + ")\n";
            returnString += "\t   (Due Date: " + getFutureDateString(Task.DATETIME_PRINT_FORMAT) + ")";
        }
        return returnString;
    }

    @Override
    public String toFile() {
        String isReturnString = (isReturn) ? "1" : "0";
        String dateString = getDateString(Item.DATETIME_PARSE_FORMAT);
        String futureDateString = getFutureDateString(Item.DATETIME_PARSE_FORMAT);

        return "B | " + isReturnString + " | " + description + " | " + dateString + " | " + futureDateString;
    }
}
