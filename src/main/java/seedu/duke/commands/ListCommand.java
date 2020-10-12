package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.ArrayList;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all tasks in the task list as a list with index numbers.\n"
            + "     Example: " + COMMAND_WORD;
    private final boolean hasPriority;
    private int priority;

    public ListCommand() {
        this.hasPriority = false;
    };

    public ListCommand(int priority) {
        this.hasPriority = true;
        this.priority = priority;
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        ArrayList<Task> newTasks = new ArrayList<Task>();

        if (hasPriority == true) {
            if (priority < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() == priority) {
                    newTasks.add(tasks.get(i));
                }
            }
            TaskList newTaskList = new TaskList(newTasks);
            newTaskList.listTask(priority);
        } else {
            tasks.listTask();
        }

    }
}
