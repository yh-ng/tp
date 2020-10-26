package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a list of books.
 */
public class BookList extends ItemList<Book> {

    /**
     * Constructs a task list with the given tasks.
     *
     * @param books an ArrayList of tasks
     */
    public BookList(ArrayList<Book> books) {
        this.items = books;
    }

    /**
     * Constructs an empty task list.
     */
    public BookList() {
        items = new ArrayList<>();
    }

    @Override
    public void addTodo(String description) {
        Book newBook = new Book(description);
        items.add(newBook);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newBook.toString() + Messages.MESSAGE_STATUS_FIRST
                + items.size() + Messages.MESSAGE_STATUS_LAST);
    }
}

