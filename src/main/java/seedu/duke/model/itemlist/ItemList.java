package seedu.duke.model.itemlist;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.item.Item;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;

// Renamed from previous Task.java with some modifications.

/**
 * Represents a list of items.
 */
public abstract class ItemList<T extends Item> {

    protected ArrayList<T> items;


    /**
     * Constructs an item list with the given items.
     *
     * @param items an ArrayList of any type of objects
     */
    public ItemList(ArrayList<T> items) {
        this.items = items;
    }

    /**
     * Constructs an empty item list.
     */
    public ItemList() {
        items = new ArrayList<>();
    }

    /**
     * Retrieves the list of items.
     *
     * @return an ArrayList of items
     */
    public ArrayList<T> getTaskList() {
        return items;
    }

    /**
     * Adds an item to the item list from the parameters.
     *
     * @param item Item to be added to the item list.
     */
    public void addItem(T item) {
        items.add(item);
        Ui.dukePrint(Messages.MESSAGE_ADD_LINK + item.toString() + Messages.MESSAGE_STATUS_FIRST
                + items.size() + Messages.MESSAGE_STATUS_LAST);
    }


    /**
     * Adds an item into the list.
     *
     * @param description the description of the item
     */
    public abstract void addTodo(String description);

    /**
     * Deletes an item from the list, identified by the index of the item in the list.
     *
     * @param index the index of the item in the list
     */
    public void deleteTask(int index) {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            Item itemRemoved = items.get(index - 1);
            Ui.dukePrint(Messages.MESSAGE_DELETE + itemRemoved.toString() + Messages.MESSAGE_STATUS_FIRST
                    + (items.size() - 1) + Messages.MESSAGE_STATUS_LAST);
            items.remove(index - 1);
        }
    }

    /**
     * Deletes an item from the list, identified by the index of the item in the list.
     *
     * @param taskIndex the index of the item in the list
     */
    public void deletePriorityOrCategoryTask(int taskIndex) {
        items.remove(taskIndex);
    }

    /**
     * Displays the item deleted from the list.
     *
     * @param itemsDeleted the item deleted from the list
     * @param isCategory   whether to display all the tasks with the same category
     */
    public void displayDeletedPriorityOrCategoryTask(ArrayList<T> itemsDeleted, boolean isCategory) {
        Ui.showLine();
        if (isCategory) {
            Ui.dukePrintMultiple(Messages.MESSAGE_DELETE_TASK_WITH_CATEGORY);
        } else {
            Ui.dukePrintMultiple(Messages.MESSAGE_DELETE_TASK_WITH_PRIORITY);
        }
        Ui.showLine();
        Collections.reverse(itemsDeleted);
        for (Item item : itemsDeleted) {
            Ui.dukePrintMultiple(item.toString());
        }
        Ui.dukePrintMultiple(Messages.MESSAGE_STATUS_FIRST
                + (items.size()) + Messages.MESSAGE_STATUS_LAST);
        Ui.showLine();
    }

    /**
     * Lists all the tasks in the task list.
     */
    public void listTask() {
        String message = "";
        if (items.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_TASK_LIST);
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + items.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_TASK_LIST + message);
    }

    public void listTask(int priority) {
        String message = "";
        if (items.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LIST_WITH_PRIORITY);
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + items.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST_WITH_PRIORITY + message);
    }

    public void listTask(String category) {
        String message = "";
        if (items.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LIST_WITH_CATEGORY);
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + items.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST_WITH_CATEGORY + message);
    }

    /**
     * Clears all the items in the list.
     */
    public void clearTask() {
        items = new ArrayList<>();
        Ui.dukePrint(Messages.MESSAGE_CLEAR);
    }

    /**
     * Marks the item, identified by the index of the item in the item list, as done (for tasks) or returned (for
     * books).
     *
     * @param index the index of the item in the list
     */
    public void markTaskAsDone(int index) {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            items.get(index - 1).markAsDone();
            Ui.dukePrint(Messages.MESSAGE_DONE + items.get(index - 1).getDescription());
        }
    }

    /**
     * Finds and lists all tasks in the task list whose description contains the argument keywords.
     * Keyword matching is case-insensitive.
     *
     * @param keyword the keyword to be searched in the task list
     */
    public void findTask(String keyword) {
        ArrayList<T> matchingTasks = new ArrayList<>();
        int count = 0;
        String message = "";
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(items.get(i));
                count++;
                message = message + "\n     " + count + "." + items.get(i).toString();
            }
        }
        if (!message.equals("")) {
            Ui.dukePrint(Messages.MESSAGE_FIND + message);
        } else {
            Ui.dukePrint(Messages.MESSAGE_NOT_FOUND);
        }
    }

    /**
     * Retrieves the size of the task list.
     *
     * @return the size of the task list
     */
    public int size() {
        return items.size();
    }

    /**
     * Retrieves a task using the given index.
     *
     * @param index the index of the task to be retrieved
     * @return the task in the task list at the given index
     */
    public T get(int index) {
        return items.get(index);
    }

    /**
     * Sets the date of a task at the given index.
     *
     * @param index the index of the task to set priority.
     * @param date  the date to set the task at.
     */
    public void setDate(int index, String date) throws DukeException {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            items.get(index - 1).setDateFromString(date);
            Ui.dukePrint(Messages.MESSAGE_DATE + items.get(index - 1).toString());
        }
    }
}
