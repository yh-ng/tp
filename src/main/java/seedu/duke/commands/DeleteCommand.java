package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.LinkList;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.model.item.Task;

import java.util.ArrayList;

// @@author MuhammadHoze

/**
 * Deletes a Task identified by its index in the task list.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the task identified by the index number used in the task listing.\n"
            + "     Parameters: INDEX\n"
            + "     Example: " + COMMAND_WORD + " task" + " 1\n"
            + "          Optional parameter 1: p/PRIORITY\n"
            + "             Deletes all the tasks with PRIORITY.\n"
            + "             Example: " + COMMAND_WORD + " tasks" + " p/1\n"
            + "          Optional parameter 2: c/CATEGORY\n"
            + "             Deletes all the tasks with CATEGORY.\n"
            + "             Example: " + COMMAND_WORD + " tasks" + " c/cs2113.\n"
            + "     Deletes the link identified by the index number used in the link listing.\n"
            + "     Parameters: INDEX\n"
            + "     Example: " + COMMAND_WORD + " link" + " 1\n";

    private boolean hasPriorityValue = false;
    private boolean hasCategoryValue = false;
    private String categoryValue = "";
    private int index;
    private int priorityIndex;
    private boolean isLink;
    private ListType deleteType;


    public DeleteCommand(int index) {
        assert index > 0 : "Task number should be greater than 0";
        this.hasPriorityValue = false;
        this.hasCategoryValue = false;
        this.index = index;
    }

    public DeleteCommand(String inputValue) {
        if (inputValue.startsWith("p")) {
            this.hasPriorityValue = true;
            this.priorityIndex = Integer.parseInt(inputValue.substring(2));
        } else if (inputValue.startsWith("c")) {
            this.hasCategoryValue = true;
            this.categoryValue = inputValue.substring(2);
        }
    }

    public DeleteCommand(int index, boolean isLink) {
        assert index > 0 : "Task number should be greater than 0";
        this.hasPriorityValue = false;
        this.hasCategoryValue = false;
        this.isLink = isLink;
        this.index = index;
    }

    public DeleteCommand(int index, ListType deleteType) {
        this.index = index;
        this.deleteType = deleteType;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        LinkList links = (LinkList) model.getList(ListType.LINK_LIST);
        ArrayList<Task> taskDeleted = new ArrayList<Task>();
        boolean isCategory = false;

        if (hasPriorityValue) {
            if (priorityIndex < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            for (int i = tasks.size() - 1; i >= 0; i--) {
                if (tasks.get(i).getPriority() == priorityIndex) {
                    taskDeleted.add(tasks.get(i));
                    tasks.deletePriorityOrCategoryTask(i);
                }
            }
            if (taskDeleted.isEmpty()) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            tasks.displayDeletedPriorityOrCategoryTask(taskDeleted, isCategory);
        } else if (hasCategoryValue) {
            isCategory = true;
            for (int i = tasks.size() - 1; i >= 0; i--) {
                if (tasks.get(i).getCategory() == null) {
                    continue; //ignore if category is not set for the task
                }
                if (tasks.get(i).getCategory().equals(categoryValue)) {
                    taskDeleted.add(tasks.get(i));
                    tasks.deletePriorityOrCategoryTask(i);
                }
            }
            if (taskDeleted.isEmpty()) {
                throw new DukeException(Messages.EXCEPTION_CATEGORY_NOT_FOUND);
            }
            tasks.displayDeletedPriorityOrCategoryTask(taskDeleted, isCategory);
        } else if (isLink) {
            links.deleteLink(index);
        } else if (deleteType == ListType.MODULE_LIST) {
            model.getList(ListType.MODULE_LIST).deleteTask(index);
        } else {
            tasks.deleteTask(index);
        }
    }
}
