package seedu.duke.model.item;

/**
 * Represents a task in the task list.
 */
public class Task extends Item {

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param description the description of the task
     */
    public Task(String description) {
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
    public Task(String description, boolean isDone, int priority) {
        super(description, isDone, priority);
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

    /**
     * Converts the attributes of the task into a formatted string to be displayed to the user.
     *
     * @return the formatted string to be displayed to the user
     */
    public String toString() {
        String returnString;
        if (this.isDone) {
            returnString = "[T][Y] " + this.description + " (p:" + this.getPriority() + ")";
        } else {
            returnString = "[T][N] " + this.description + " (p:" + this.getPriority() + ")";
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
     * Converts the attributes of the task into a formatted string to be saved into the storage file.
     *
     * @return the formatted string to be saved into the storage file
     */
    @Override
    public String toFile() {
        String isDoneString = (isDone) ? "1" : "0";
        String categoryString = (category == null) ? "" : category;
        String dateString = getDateString(Item.DATETIME_PARSE_FORMAT);
        return "T | " + isDoneString + " | " + description + " | " + priority + " | " + categoryString + " | "
                + dateString;
    }
}
