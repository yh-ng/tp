package seedu.duke.model.itemlist;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.item.Book;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

// @@author MuhammadHoze

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

    public ArrayList<Book> getBookList() {
        return items;
    }

    /**
     * Adds a book to the book list from the parameters.
     *
     * @param book Book to be added to the book list.
     */
    public void addBook(Book book) throws DukeException {
        checkBookAlreadyExists(book);
        items.add(book);
        Ui.dukePrint(Messages.MESSAGE_ADD_BOOK + book.toString(false));
    }

    @Override
    public void addTodo(String description) {
    }

    /**
     * Clears all the books in the list.
     */
    public void clearBook() {
        items = new ArrayList<>();
    }


    public void markAsReturn(int index) {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_BOOK);
        } else {
            items.get(index - 1).markAsReturn();
            Ui.dukePrint(Messages.MESSAGE_RETURNED + items.get(index - 1).getDescription());
        }
    }

    public void listBook() {
        String message = "";
        if (items.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_BOOK_LIST);
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            message += "\n     " + (i + 1) + "." + items.get(i).toString(true);
        }
        Ui.dukePrint(Messages.MESSAGE_BOOK_LIST + message);
    }

    private void checkBookAlreadyExists(Book book) throws DukeException {
        int count = (int) items.stream()
                .filter(existingBook -> existingBook.getDescription().equals(book.getDescription()))
                .count();
        if (count != 0) {
            throw new DukeException("~Error~ Book already exists!");
        }
    }
}

