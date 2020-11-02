package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;

/**
 * Clears all tasks in the task list.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Clears all tasks in the task list.\n"
            + "     Example: " + COMMAND_WORD;

    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        tasks.clearTask();
    }
}
