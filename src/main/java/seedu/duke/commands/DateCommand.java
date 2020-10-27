package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
     * @param listMap a Map object containing all lists
     */
    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
        if (!argumentsMap.containsKey("date")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }
        tasks.setDate(index, argumentsMap.get("date"));
    }
}
