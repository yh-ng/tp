package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.TaskList;
import seedu.duke.task.Todo;

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
