package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 */
public class TaskList extends ItemList<Task> {

    /**
     * Constructs a task list with the given tasks.
     *
     * @param tasks an ArrayList of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.items = tasks;
    }

    /**
     * Constructs an empty task list.
     */
    public TaskList() {
        items = new ArrayList<>();
    }

    /**
     * Adds a list of tasks to the task list.
     *
     * @param newTaskList ArrayList of new tasks.
     */
    public void addTasksFromList(ArrayList<Task> newTaskList) {
        Ui.showLine();
        if (newTaskList.size() <= 0) {
            Ui.dukePrintMultiple(Messages.WARNING_NO_TASK);
        } else {
            Ui.dukePrintMultiple(Messages.MESSAGE_ADD_MULTIPLE_TASK);
            for (Task task: newTaskList) {
                items.add(task);
                Ui.dukePrintMultiple(task.toString());
            }
            Ui.dukePrintMultiple(Messages.MESSAGE_STATUS_FIRST + items.size() + Messages.MESSAGE_STATUS_LAST);
        }
        Ui.showLine();
    }

    /**
     * Adds a todo task to the task list.
     *
     * @param description the description of the todo task
     */
    @Override
    public void addTodo(String description) {
        Task newTask = new Task(description);
        items.add(newTask);
        Ui.dukePrint(Messages.MESSAGE_ADDTASK + newTask.toString() + Messages.MESSAGE_STATUS_FIRST
                + items.size() + Messages.MESSAGE_STATUS_LAST);
    }
}
