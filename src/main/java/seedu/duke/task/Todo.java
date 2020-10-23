package seedu.duke.task;

/**
 * Represents a todo task in the task list.
 */
public class Todo extends Task {

    /**
     * Constructor used when adding a new todo task.
     * By default, the todo task is not done.
     *
     * @param description the description of the todo task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the todo task
     * @param isDone true if the todo task is done already, false otherwise
     */
    public Todo(String description, boolean isDone, int priority) {
        super(description, isDone, priority);
    }

    @Override
    public String toFile() {
        String isDoneString = (isDone) ? "1" : "0";
        String categoryString = (category == null) ? "" : category;
        String dateString = getDateString(Task.DATETIME_PARSE_FORMAT);
        return "T | " + isDoneString + " | " + description + " | " + priority + " | " + categoryString + " | "
                + dateString;
    }

    @Override
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
            returnString += " (date: " + getDateString(Task.DATETIME_PRINT_FORMAT) + ")";
        }
        return returnString;
    }
}
