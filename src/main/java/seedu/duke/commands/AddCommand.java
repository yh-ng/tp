package seedu.duke.commands;

import seedu.duke.task.TaskList;

import java.util.HashMap;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a todo task to the task list.\n";
    private final String description;
    private final HashMap<String, String> argumentsMap;

    public AddCommand(String description, HashMap<String, String> argumentsMap) {
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    @Override
    public void execute(TaskList tasks) {
        tasks.addTodo(description);
    }
}
