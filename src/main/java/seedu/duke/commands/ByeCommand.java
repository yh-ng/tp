package seedu.duke.commands;

import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.util.Map;

/**
 * Terminates the program.
 */

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Map<ListType, ItemList> listMap) {
        Ui.exit();
    }
}
