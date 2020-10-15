package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.TaskList;
import seedu.duke.task.Todo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a task to the task list.\n"
            + "     Parameters: TASK_NAME <optional arguments>\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional arguments>";

    private final String description;
    private final HashMap<String, String> argumentsMap;
    private final HashSet<String> allowedArguments = new HashSet<>(Arrays.asList("p", "c"));

    public AddCommand(String description, HashMap<String, String> argumentsMap) throws DukeException {
        checkAllowedArguments(argumentsMap, allowedArguments);
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    @Override
    public void execute(TaskList tasks) throws DukeException {
        Todo newTodo = new Todo(description);

        if (argumentsMap.containsKey("p")) {
            int newPriority;
            try {
                newPriority = Integer.parseInt(argumentsMap.get("p"));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }
            if (newPriority < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            newTodo.setPriority(newPriority);
        }

        if (argumentsMap.containsKey("c")) {
            if (argumentsMap.get("c") != null) {
                newTodo.setCategory(argumentsMap.get("c"));
            }
        }

        tasks.addTask(newTodo);
    }
}
