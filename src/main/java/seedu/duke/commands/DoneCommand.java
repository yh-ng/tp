package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.ModuleList;
import seedu.duke.model.itemlist.TaskList;

/**
 * Marks a Task, identified by its index in the task list, as done.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the task/module identified by the index number used in the listing as done.\n"
            + "     Parameters: <type> INDEX\n"
            + "     Accepted <type>: task, module\n"
            + "     Example: " + COMMAND_WORD + " task 1";

    private final ListType doneType;
    private final int index;

    public DoneCommand(int index, ListType doneType) {
        this.index = index;
        this.doneType = doneType;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        ModuleList modules = (ModuleList) model.getList(ListType.MODULE_LIST);
        switch (doneType) {
        case TASK_LIST:
            tasks.markItemAsDone(index);
            break;
        case MODULE_LIST:
            modules.markItemAsDone(index);
            break;
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }
}
