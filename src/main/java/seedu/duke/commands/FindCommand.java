package seedu.duke.commands;

import seedu.duke.task.TaskList;

/**
 * Finds and lists all tasks in the task list whose description contains the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks whose descriptions contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "     Parameters: KEYWORDS\n"
            + "     Example: " + COMMAND_WORD + " book";

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.findTask(keyword);
    }
}
