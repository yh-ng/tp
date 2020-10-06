package seedu.duke.commands;

import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Shows help instructions
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        String message = TodoCommand.MESSAGE_USAGE
                + "\n\n     " + DeadlineCommand.MESSAGE_USAGE
                + "\n\n     " + EventCommand.MESSAGE_USAGE
                + "\n\n     " + DeleteCommand.MESSAGE_USAGE
                + "\n\n     " + ListCommand.MESSAGE_USAGE
                + "\n\n     " + FindCommand.MESSAGE_USAGE
                + "\n\n     " + DoneCommand.MESSAGE_USAGE
                + "\n\n     " + HelpCommand.MESSAGE_USAGE
                + "\n\n     " + ByeCommand.MESSAGE_USAGE;
        Ui.dukePrint(message);
    }
}
