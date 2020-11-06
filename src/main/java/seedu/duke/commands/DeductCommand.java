package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;

public class DeductCommand extends Command {


    public static final String COMMAND_WORD = "deduct";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deduct meal credit.\n"
            + "     Parameter: value\n"
            + "     Example: " + COMMAND_WORD + " 5";


    public DeductCommand(String value){

    }


    @Override
    public void execute(Model model) throws DukeException {

    }
}
