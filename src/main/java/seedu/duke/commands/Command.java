package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.TaskList;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Represents an executable command.
 */

public abstract class Command {

    /**
     * Represents a general command.
     *
     * @return whether to exit Duke application.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Checks if the user passed in an invalid optional argument for a given command.
     *
     * @param argumentsMap HashMap containing optional arguments.
     * @param allowedArguments HashSet containing allowed arguments.
     * @throws DukeException If argumentsMap contains invalid arguments not in allowedArguments.
     */
    public void checkAllowedArguments(HashMap<String, String> argumentsMap, HashSet<String> allowedArguments)
            throws DukeException {
        for (HashMap.Entry<String, String> entry: argumentsMap.entrySet()) {
            if (!allowedArguments.contains(entry.getKey())) {
                throw new DukeException("invalid optional argument!");
            }
        }
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    public abstract void execute(TaskList tasks) throws DukeException;
}
