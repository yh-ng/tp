package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.BookList;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;

import java.util.Map;

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
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        BookList books = (BookList) listMap.get(ListType.BOOK_LIST);
        books.markBookAsReturned(index);
    }
}
