package seedu.duke.commands;

import seedu.duke.task.TaskList;

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
    public void execute(TaskList tasks) {
        tasks.markAsDone(index);
    }
}
