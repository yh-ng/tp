package seedu.duke.commands;

import seedu.duke.task.TaskList;


/**
 * Adds a Todo to the TaskList.
 */
public class TodoCommand extends Command {

    public static final String COMMAND_WORD = "todo";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a todo task to the task list.\n"
            + "     Parameters: DESCRIPTION\n"
            + "     Example: " + COMMAND_WORD
            + " read book";

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addTodo(description);
    }
}
