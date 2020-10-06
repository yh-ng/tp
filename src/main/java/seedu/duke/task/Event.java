package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.time.format.DateTimeParseException;

/**
 * Represents an Event task in the task list.
 */
public class Event extends Task {
    private String time;

    /**
     * Constructor used when adding a new event task.
     * By default, the event task is not done.
     *
     * @param description the description of the event task
     * @param time the time of the event task to be done
     */
    public Event(String description, String time) {
        super(description);
        this.time = time;
        try {
            this.time = Ui.formatDateTime(time);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the event task
     * @param isDone true if the event task is done already, false otherwise
     * @param time the time of the event task to be done
     */
    public Event(String description, boolean isDone, String time) {
        super(description, isDone);
        this.time = time;
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "E | 1 | " + description + " | " + time;
        } else {
            return "E | 0 | " + description + " | " + time;
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[E][Y] " + this.description + " (at: " + this.time + ")";
        } else {
            return "[E][N] " + this.description + " (at: " + this.time + ")";
        }
    }
}
