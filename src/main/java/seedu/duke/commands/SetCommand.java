package seedu.duke.commands;

import seedu.duke.task.TaskList;

public class SetCommand extends Command {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the task identified by the index number used in the task listing to the new priority.\n"
            + "     Parameters: INDEX p/PRIORITY\n"
            + "     Example: " + COMMAND_WORD + " 1 2";

    private final int index;
    private final int priority;

    public SetCommand(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    @Override
    public void execute(TaskList tasks) {
        tasks.setPriority(index, priority);
    }
}
