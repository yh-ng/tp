package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;

/**
 * Sets the category of a task identified by its index in the task list.
 */
public class CategoryCommand extends Command {
    public static final String COMMAND_WORD = "category";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the category of a task identified by the task index number in the task list\n"
            + "     Parameters: INDEX c/CATEGORY\n"
            + "     Example: " + COMMAND_WORD + " 1 c/Academics";

    private int index;
    private String category;

    public CategoryCommand(int index, String category) {
        this.index = index;
        this.category = category;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        tasks.setCategory(index, category);
    }
}
