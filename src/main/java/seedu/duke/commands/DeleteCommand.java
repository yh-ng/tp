package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.ArrayList;

/**
 * Deletes a Task identified by its index in the task list.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the task identified by the index number used in the task listing.\n"
            + "     Parameters: INDEX\n"
            + "     Example: " + COMMAND_WORD + " 1";

    private final boolean hasPriorityValue;
    private int index;
    private int priorityIndex;
    private static final Logger deleteCommandLogger = Logger.getLogger(DeleteCommand.class.getName());


    public DeleteCommand(int index) {
        assert index > 0 : "Task number should be greater than 0";
        this.hasPriorityValue = false;
        this.index = index;
    }

    public DeleteCommand(String priorityValue) {
        this.hasPriorityValue = true;
        this.priorityIndex = Integer.parseInt(priorityValue.substring(2));
        deleteCommandLogger.log(Level.WARNING, "Priority should be non-negative");
    }

    @Override
    public void execute(TaskList tasks) throws DukeException {
        ArrayList<Task> taskDeleted = new ArrayList<Task>();

        if (hasPriorityValue) {
            if (priorityIndex < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            for (int i = tasks.size() - 1; i >= 0; i--) {
                if (tasks.get(i).getPriority() == priorityIndex) {
                    taskDeleted.add(tasks.get(i));
                    tasks.deletePriorityTask(i);
                }
            }
            if (taskDeleted.isEmpty()) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            tasks.displayDeletedPriorityTask(taskDeleted);

        } else {
            tasks.deleteTask(index);
        }
    }
}
