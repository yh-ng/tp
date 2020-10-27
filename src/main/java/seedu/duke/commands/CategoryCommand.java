package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;

import java.util.Map;

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
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
        tasks.setCategory(index, category);
    }
}
