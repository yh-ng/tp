package seedu.duke.commands;

import seedu.duke.DukeException;

import seedu.duke.model.Model;
import seedu.duke.model.item.Book;
import seedu.duke.model.itemlist.BookList;
import seedu.duke.model.ListType;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

// @@author MuhammadHoze

public class BorrowCommand extends Command {

    public static final String COMMAND_WORD = "borrow";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a book to the book list.\n"
            + "     Example: " + COMMAND_WORD + " example_book  date/DD-MM-YYYY";
    private String description = "";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Collections.singletonList("date"));
    private final HashMap<String, String> argumentsMap;

    public BorrowCommand(String description, HashMap<String, String> argumentsMap) {
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    @Override
    public void execute(Model model) throws DukeException {

        BookList books = (BookList) model.getList(ListType.BOOK_LIST);
        Book newBook = new Book(description);

        if (argumentsMap.containsKey("date")) {
            newBook.setDateFromString(argumentsMap.get("date"));
        }
        books.addBook(newBook);
    }
}
