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
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toFile() {
        if (isDone) {
            return "T | 1 | " + description + " | " + this.getPriority() + " | ";
        } else {
            return "T | 0 | " + description + " | " + this.getPriority() + " | ";
        }
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[T][Y] " + this.description + " (p:" + this.getPriority() + ")";
        } else {
            return "[T][N] " + this.description + " (p:" + this.getPriority() + ")";
        }
    }
}
