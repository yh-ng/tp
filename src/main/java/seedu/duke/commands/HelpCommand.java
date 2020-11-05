package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.ui.Ui;

/**
 * Shows help instructions.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "     Example: " + COMMAND_WORD;

    @Override
    public void execute(Model model) throws DukeException {
        /*
        list of help commands is in alphabetical order
         */
        String message = AddCommand.MESSAGE_USAGE
                + "\n\n     " + AddRecurringCommand.MESSAGE_USAGE
                + "\n\n     " + BorrowCommand.MESSAGE_USAGE
                + "\n\n     " + ByeCommand.MESSAGE_USAGE
                + "\n\n     " + CalendarCommand.MESSAGE_USAGE
                + "\n\n     " + CategoryCommand.MESSAGE_USAGE
                + "\n\n     " + ClearCommand.MESSAGE_USAGE
                + "\n\n     " + DateCommand.MESSAGE_USAGE
                + "\n\n     " + DeleteCommand.MESSAGE_USAGE
                + "\n\n     " + DoneCommand.MESSAGE_USAGE
                + "\n\n     " + FindCommand.MESSAGE_USAGE
                + "\n\n     " + HelpCommand.MESSAGE_USAGE
                + "\n\n     " + ListCommand.MESSAGE_USAGE
                + "\n\n     " + ReturnCommand.MESSAGE_USAGE
                + "\n\n     " + SetCommand.MESSAGE_USAGE;
       
        Ui.dukePrint(message);
    }
}
