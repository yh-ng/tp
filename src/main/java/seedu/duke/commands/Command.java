package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;

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
     * Executes the command.
     *
     * @param model Model representing program data in memory.
     */
    public abstract void execute(Model model) throws DukeException;
}
