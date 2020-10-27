package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// @@author iamchenjiajun
/**
 * Represents a command that adds a task to the task list.
 */
public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a task to the task list.\n"
            + "     Parameters: TASK_NAME <optional arguments>\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional arguments>";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p", "c", "date"));

    protected final String description;
    protected final HashMap<String, String> argumentsMap;

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
        Task newTask = new Task(description);
        setTaskProperties(newTask, argumentsMap);
        tasks.addTask(newTask);
    }

    /**
     * Sets the properties of a given Task.
     *
     * @param task Task to set the properties of.
     * @param argumentsMap HashMap containing arguments to set the Task properties.
     * @throws DukeException If arguments in HashMap are invalid.
     */
    protected void setTaskProperties(Task task, HashMap<String, String> argumentsMap) throws DukeException {
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
            task.setPriority(newPriority);
        }

        if (argumentsMap.containsKey("c")) {
            if (argumentsMap.get("c") != null) {
                task.setCategory(argumentsMap.get("c"));
            }
        }

        if (argumentsMap.containsKey("date")) {
            task.setDateFromString(argumentsMap.get("date"));
        }
    }
}
