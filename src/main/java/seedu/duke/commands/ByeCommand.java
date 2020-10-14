package seedu.duke.commands;

import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Terminates the program.
 */

public class ByeCommand extends Command {

    public static final String COMMAND_WORD = "exit";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks) {
        Ui.exit();
    }
}
