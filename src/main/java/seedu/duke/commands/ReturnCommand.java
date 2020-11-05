package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.BookList;
import seedu.duke.model.ListType;

// @@author MuhammadHoze

public class ReturnCommand extends Command {

    public static final String COMMAND_WORD = "return";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the book identified by the index number used in the book list as returned.\n"
            + "     Parameters: INDEX\n"
            + "     Example: " + COMMAND_WORD + " 2";

    private int index;

    public ReturnCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Model model) throws DukeException {
        BookList books = (BookList) model.getList(ListType.BOOK_LIST);
        books.markAsReturn(index);
    }
}
