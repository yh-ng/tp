package seedu.duke.task;

/**
 * Represents a task in the task list.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected int priority;

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Convenience constructor used when loading from the storage file.
     *
     * @param description the description of the task
     * @param isDone true if the task is done already, false otherwise
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Retrieves the description of a task.
     *
     * @return the description string of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves whether the task in done.
     *
     * @return true if the task is done already, false otherwise
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Converts the attributes of the task into a formatted string to be saved into the storage file.
     *
     * @return the formatted string to be saved into the storage file
     */
    public abstract String toFile();

    /**
     * Converts the attributes of the task into a formatted string to be displayed to the user.
     *
     * @return the formatted string to be displayed to the user
     */
    public abstract String toString();

    /**
     * Retrieves the priority of a task.
     *
     * @return Priority of the task.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority of a task.
     *
     * @param priority New priority of the task.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
