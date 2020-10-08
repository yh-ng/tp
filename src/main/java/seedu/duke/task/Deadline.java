package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.time.format.DateTimeParseException;

/**
 * Represents a deadline task in the task list.
 */
public class Deadline extends Task {
    private String deadline;

    /**
     * Constructor used when adding a new deadline task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the deadline task
     * @param deadline the deadline of the task
     */
    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        try {
            this.deadline = Ui.formatDateTime(deadline);
        } catch (DateTimeParseException e) {
            Ui.dukePrint(Messages.WARNING_DATETIME);
        }
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the deadline task
     * @param isDone true if the deadline task is done already, false otherwise
     * @param deadline the deadline of the task
     */
    public Deadline(String description, boolean isDone, String deadline) {
        super(description, isDone);
        this.deadline = deadline;
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "D | 1 | " + description + " | " + deadline;
        } else {
            return "D | 0 | " + description + " | " + deadline;
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[D][Y] " + description + " (by: " + deadline + ")";
        } else {
            return "[D][N] " + description + " (by: " + deadline + ")";
        }
    }
}
