package seedu.duke.commands;

import seedu.duke.model.Model;
import seedu.duke.ui.Ui;

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
    public void execute(Model model) {
        Ui.exit();
    }
}
