package seedu.duke.task;

/**
 * Represents a task in the task list.
 */
public class Book extends Item {

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the task
     */
    public Book(String description) {
        super(description);
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
    public Book(String description, boolean isDone, int priority) {
        super(description, isDone, priority);
    }
}
