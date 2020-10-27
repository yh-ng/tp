package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
     * @param listMap a TaskList object containing all tasks
     */
    public abstract void execute(Map<ListType, ItemList> listMap) throws DukeException;
}
