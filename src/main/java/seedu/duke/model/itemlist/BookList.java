package seedu.duke.model.itemlist;

import seedu.duke.common.Messages;
import seedu.duke.model.item.Book;
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

    public ArrayList<Book> getBookList() {
        return items;
    }

    /**
     * Adds a book to the book list from the parameters.
     *
     * @param book Book to be added to the book list.
     */
    public void addBook(Book book) {
        items.add(book);
        Ui.dukePrint(Messages.MESSAGE_ADDBOOK + book.toString(false));
    }

    @Override
    public void addTodo(String description) {
        Book newBook = new Book(description);
        items.add(newBook);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newBook.toString() + Messages.MESSAGE_STATUS_FIRST
                + items.size() + Messages.MESSAGE_STATUS_LAST);
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
}

