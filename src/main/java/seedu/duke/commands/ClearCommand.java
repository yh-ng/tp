package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Clears all tasks in the task list.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Clears all tasks in the task list.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public void execute(TaskList tasks) {
        tasks.clearTask();
    }
}
