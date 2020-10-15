package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.TaskList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SetCommand extends Command {
    public static final String COMMAND_WORD = "set";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the task identified by the index number used in the task listing to the new priority.\n"
            + "     Parameters: INDEX p/PRIORITY\n"
            + "     Example: " + COMMAND_WORD + " 1 p/2";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p"));

    private final int index;
    private final HashMap<String, String> argumentsMap;

    public SetCommand(int index, HashMap<String, String> argumentsMap) {
        this.index = index;
        this.argumentsMap = argumentsMap;
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    @Override
    public void execute(TaskList tasks) throws DukeException {
        int priority;

        try {
            priority = Integer.parseInt(argumentsMap.get("p"));
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
        }

        if (priority < 0) {
            throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
        }
        tasks.setPriority(index, priority);
    }
}
