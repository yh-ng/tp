package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Represents an executable command.
 */

public abstract class Command {

    /**
     * @return whether to exit Duke application.
     */
    public abstract boolean isExit();

    /**
     * Executes the command.
     * @param tasks a TaskList object containing all tasks
     */
    public abstract void execute(TaskList tasks);
}
