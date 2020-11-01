package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;

/**
 * Marks a Task, identified by its index in the task list, as done.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the task identified by the index number used in the task listing as done.\n"
            + "     Parameters: INDEX\n"
            + "     Example: " + COMMAND_WORD + " 1";

    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        tasks.markTaskAsDone(index);
    }
}
