package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Adds a Deadline to the TaskList.
 */
public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a deadline task to the task list. \n"
            + "     Parameters: DESCRIPTION /by DEADLINE\n"
            + "     Example: " + COMMAND_WORD
            + " return book /by 2021-06-06 12:00";

    private String description;
    private String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addDeadline(description, deadline);
    }
}
