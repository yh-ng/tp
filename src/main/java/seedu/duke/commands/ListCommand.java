package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all tasks in the task list as a list with index numbers.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public void execute(TaskList tasks) {
        tasks.listTask();
    }
}
