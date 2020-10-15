package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a list of tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Constructs a task list with the given tasks.
     *
     * @param tasks an ArrayList of Task objects
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


    /**
     * Constructs an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return an ArrayList of {@code Task}
     */
    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    /**
     * Adds a task to the task list from the parameters.
     *
     * @param task Task to be added to the task list.
     */
    public void addTask(Task task) {
        tasks.add(task);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + task.toString() + Messages.MESSAGE_STATUS_FIRST
                + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    /**
     * Adds a todo task to the task list.
     *
     * @param description the description of the todo task
     */
    public void addTodo(String description) {
        Todo newTodo = new Todo(description);
        tasks.add(newTodo);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newTodo.toString() + Messages.MESSAGE_STATUS_FIRST
                + tasks.size() + Messages.MESSAGE_STATUS_LAST);
    }

    /**
     * Deletes a task from the list, identified by the index of the task in the task list.
     *
     * @param index the index of the task in the task list
     */
    public void deleteTask(int index) { // have to differentiate all priority or individual task deletion
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            Task taskRemoved = tasks.get(index - 1); // task is the arraylist
            Ui.dukePrint(Messages.MESSAGE_DELETE + taskRemoved.toString() + Messages.MESSAGE_STATUS_FIRST
                    + (tasks.size() - 1) + Messages.MESSAGE_STATUS_LAST);
            tasks.remove(index - 1);
        }
    }

    public void deletePriorityTask(int taskIndex) {
        tasks.remove(taskIndex);
    }

    public void displayDeletedPriorityTask(ArrayList<Task> taskDeleted) {
        Ui.showLine();
        Ui.dukePrintMultiple(Messages.MESSAGE_DELETE_TASK_WITH_PRIORITY);
        Ui.showLine();
        Collections.reverse(taskDeleted);
        for (Task task : taskDeleted) {
            Ui.dukePrintMultiple(task.toString());
        }
        Ui.dukePrintMultiple(Messages.MESSAGE_STATUS_FIRST
                + (tasks.size()) + Messages.MESSAGE_STATUS_LAST);
        Ui.showLine();
    }

    /**
     * Lists all the tasks in the task list.
     */
    public void listTask() {
        String message = "";
        if (tasks.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LIST);
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + tasks.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST + message);
    }

    public void listTask(int priority) {
        String message = "";
        if (tasks.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LIST_WITH_PRIORITY);
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + tasks.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST_WITH_PRIORITY + message);
    }

    /**
     * Clears all the tasks in the task list.
     */
    public void clearTask() {
        tasks = new ArrayList<>();
        Ui.dukePrint(Messages.MESSAGE_CLEAR);
    }

    /**
     * Marks the task, identified by the index of the task in the task list, as done.
     *
     * @param index the index of the task in the task list
     */
    public void markAsDone(int index) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            tasks.get(index - 1).markAsDone();
            Ui.dukePrint(Messages.MESSAGE_DONE + tasks.get(index - 1).getDescription());
        }
    }

    /**
     * Sets the category of a task identified by the task index number in the task list.
     *
     * @param index the index of the task in the task list
     */
    public void setCategory(int index, String category) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            tasks.get(index - 1).setCategory(category);
            Ui.dukePrint(Messages.MESSAGE_CATEGORY + tasks.get(index - 1).toString());
        }
    }

    /**
     * Finds and lists all tasks in the task list whose description contains the argument keywords.
     * Keyword matching is case-insensitive.
     *
     * @param keyword the keyword to be searched in the task list
     */
    public void findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        int count = 0;
        String message = "";
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).description.toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(tasks.get(i));
                count++;
                message = message + "\n     " + count + "." + tasks.get(i).toString();
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
        return tasks.size();
    }

    /**
     * Retrieves a task using the given index.
     *
     * @param index the index of the task to be retrieved
     * @return the task in the task list at the given index
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Sets the priority of a task at the given index.
     *
     * @param index    the index of the task to set priority.
     * @param priority the priority to set the task at.
     */
    public void setPriority(int index, int priority) {
        if (index > tasks.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_TASK);
        } else {
            tasks.get(index - 1).setPriority(priority);
            Ui.dukePrint(Messages.MESSAGE_SET_PRIORITY + tasks.get(index - 1).getPriority());
        }
    }
}
