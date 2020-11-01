package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.item.Book;
import seedu.duke.model.itemlist.BookList;
import seedu.duke.model.itemlist.LinkList;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.model.item.Task;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all items in the list with index numbers.\n"
            + "     Example: " + COMMAND_WORD + " all\n"
            + "     Displays all items in the list.\n"
            + "          Optional parameter 1: tasks p/PRIORITY\n"
            + "             Displays all the tasks with PRIORITY as a list.\n"
            + "             Example: " + COMMAND_WORD + " tasks p/1\n"
            + "          Optional parameter 2: tasks c/CATEGORY\n"
            + "             Displays all the tasks with CATEGORY as a list.\n"
            + "             Example: " + COMMAND_WORD + " tasks c/cs2113\n"
            + "          Optional parameter 3: tasks sorted\n"
            + "             Displays all the tasks sorted by priority";
    private boolean hasPriority;
    private boolean hasCategory;
    private int priority;
    private String category;
    private boolean isSorted;
    private boolean isBook;
    public static int listSize;
    public static int newListSize;
    private boolean isLink;

    public ListCommand() {
        this.hasPriority = false;
        this.hasCategory = false;
    }

    public ListCommand(int priority) {
        this.hasPriority = true;
        this.hasCategory = false;
        this.isSorted = false;
        this.priority = priority;
    }

    public ListCommand(String category) {
        this.hasPriority = false;
        this.hasCategory = true;
        this.isSorted = false;
        this.category = category;
    }

    public ListCommand(boolean isSorted, boolean isLink) {
        if (isSorted) {
            this.hasPriority = false;
            this.hasCategory = false;
            this.isSorted = true;
        } else if (isLink) {
            this.hasPriority = false;
            this.hasCategory = false;
            this.isLink = true;

        }
    }

    public ListCommand(boolean isSorted, boolean isLink, boolean isBook) {
        if (isSorted) {
            this.hasPriority = false;
            this.hasCategory = false;
            this.isSorted = isSorted;
        } else if (isLink) {
            this.hasPriority = false;
            this.hasCategory = false;
            this.isLink = isLink;
        } else if (isBook) {
            this.hasPriority = false;
            this.hasCategory = false;
            this.isBook = isBook;
        }
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        BookList books = (BookList) model.getList(ListType.BOOK_LIST);
        LinkList links = (LinkList) model.getList(ListType.LINK_LIST);

        ArrayList<Task> newTasks = new ArrayList<Task>();
        ArrayList<Book> newBooks = new ArrayList<Book>();
        listSize = tasks.size();
        if (hasPriority) {
            if (priority < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() == priority) {
                    newTasks.add(tasks.get(i));
                }
            }
            TaskList newTaskList = new TaskList(newTasks);
            newTaskList.listTask(priority);
        } else if (hasCategory) {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getCategory() == null) {
                    continue;
                }
                if (tasks.get(i).getCategory().equals(category)) {
                    newTasks.add((Task) tasks.get(i));
                }
            }
            TaskList newTaskList = new TaskList(newTasks);
            newTaskList.listTask(category);
        } else if (isSorted) {
            newTasks = tasks.getTaskList();
            Collections.sort(newTasks);
            TaskList newTaskList = new TaskList(newTasks);
            newTaskList.listTask();
        } else if (isBook) {
            newBooks = books.getBookList();
            BookList newBookList = new BookList(newBooks);
            newBookList.listBook();
        } else if (isLink) {
            links.listLink();
        } else {
            tasks.listTask();
        }
        newListSize = newTasks.size();
    }

    public int getSize(Boolean isNew) {
        if (isNew) {
            return newListSize;
        } else {
            return listSize;
        }
    }
}
