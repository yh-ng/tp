package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DateCommand extends Command {
    public static final String COMMAND_WORD = "date";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the date of a given task in the list.\n"
            + "     Example: " + COMMAND_WORD + " <taskIndex>" + " date/DD-MM-YYYY";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("date"));

    private final int index;
    private final HashMap<String, String> argumentsMap;

    public DateCommand(int index, HashMap<String, String> argumentsMap) {
        this.index = index;
        this.argumentsMap = argumentsMap;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        if (!argumentsMap.containsKey("date")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }
        tasks.setDate(index, argumentsMap.get("date"));
    }
}
