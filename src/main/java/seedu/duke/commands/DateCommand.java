package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.TaskList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DateCommand extends Command {
    public static final String COMMAND_WORD = "date";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the date of a given task in the list.";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("date"));

    private final int index;
    private final HashMap<String, String> argumentsMap;

    public DateCommand(int index, HashMap<String, String> argumentsMap) {
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
        if (!argumentsMap.containsKey("date")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }
        tasks.setDate(index, argumentsMap.get("date"));
    }
}
