package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.ui.Ui;

import java.util.Date;
import java.util.List;

/**
 * Shows help instructions.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";
    public static final String MESSAGE_DESCRIPTION = COMMAND_WORD
            + ": Shows program or command usage instructions.\n";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program or command usage instructions.\n"
            + "     Example: " + COMMAND_WORD + "\n"
            + "     Example: " + COMMAND_WORD + " add";


    private String helpWord;

    public HelpCommand(String helpWord) {
        this.helpWord = helpWord;
    }

    @Override
    public void execute(Model model) throws DukeException {
        /*
        list of help commands is in alphabetical order
         */
        switch (helpWord) {
        case "":
            String generalMessage = AddCommand.MESSAGE_DESCRIPTION
                + "     " + AddRecurringCommand.MESSAGE_DESCRIPTION
                + "     " + BorrowCommand.MESSAGE_DESCRIPTION
                + "     " + ByeCommand.MESSAGE_DESCRIPTION
                + "     " + CalendarCommand.MESSAGE_DESCRIPTION
                + "     " + CategoryCommand.MESSAGE_DESCRIPTION
                + "     " + ClearCommand.MESSAGE_DESCRIPTION
                + "     " + DateCommand.MESSAGE_DESCRIPTION
                + "     " + DeductCommand.MESSAGE_DESCRIPTION
                + "     " + DeleteCommand.MESSAGE_DESCRIPTION
                + "     " + DoneCommand.MESSAGE_DESCRIPTION
                + "     " + FindCommand.MESSAGE_DESCRIPTION
                + "     " + HelpCommand.MESSAGE_DESCRIPTION
                + "     " + ListCommand.MESSAGE_DESCRIPTION
                + "     " + ReturnCommand.MESSAGE_DESCRIPTION
                + "     " + SetCommand.MESSAGE_DESCRIPTION;
            Ui.dukePrint(generalMessage);
            break;
        case AddCommand.COMMAND_WORD:
            Ui.dukePrint(AddCommand.MESSAGE_USAGE);
            break;
        case BorrowCommand.COMMAND_WORD:
            Ui.dukePrint(BorrowCommand.MESSAGE_USAGE);
            break;
        case ByeCommand.COMMAND_WORD:
            Ui.dukePrint(ByeCommand.MESSAGE_USAGE);
            break;
        case CalendarCommand.COMMAND_WORD:
            Ui.dukePrint(CalendarCommand.MESSAGE_USAGE);
            break;
        case CategoryCommand.COMMAND_WORD:
            Ui.dukePrint(CategoryCommand.MESSAGE_USAGE);
            break;
        case ClearCommand.COMMAND_WORD:
            Ui.dukePrint(ClearCommand.MESSAGE_USAGE);
            break;
        case DateCommand.COMMAND_WORD:
            Ui.dukePrint(DateCommand.MESSAGE_USAGE);
            break;
        case DeductCommand.COMMAND_WORD:
            Ui.dukePrint(DeductCommand.MESSAGE_USAGE);
            break;
        case DeleteCommand.COMMAND_WORD:
            Ui.dukePrint(DeleteCommand.MESSAGE_USAGE);
            break;
        case DoneCommand.COMMAND_WORD:
            Ui.dukePrint(DoneCommand.MESSAGE_USAGE);
            break;
        case FindCommand.COMMAND_WORD:
            Ui.dukePrint(FindCommand.MESSAGE_USAGE);
            break;
        case HelpCommand.COMMAND_WORD:
            Ui.dukePrint(HelpCommand.MESSAGE_USAGE);
            break;
        case ListCommand.COMMAND_WORD:
            Ui.dukePrint(ListCommand.MESSAGE_USAGE);
            break;
        case ReturnCommand.COMMAND_WORD:
            Ui.dukePrint(ReturnCommand.MESSAGE_USAGE);
            break;
        case SetCommand.COMMAND_WORD:
            Ui.dukePrint(SetCommand.MESSAGE_USAGE);
            break;
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_HELP);
        }

    }
}
