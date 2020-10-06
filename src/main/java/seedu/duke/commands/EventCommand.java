package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Adds an Event to the TaskList.
 */
public class EventCommand extends Command {

    public static final String COMMAND_WORD = "event";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an event task to the task list.\n"
            + "     Parameters: DESCRIPTION at/ TIME\n"
            + "     Example: " + COMMAND_WORD
            + " project meeting /at 2021-08-06 14:00";

    private String description;
    private String time;

    public EventCommand(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addEvent(description, time);
    }
}
