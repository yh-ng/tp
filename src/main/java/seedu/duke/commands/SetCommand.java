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
     * @param listMap a Map object containing all lists
     */
    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
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
