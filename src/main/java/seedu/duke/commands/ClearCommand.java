package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.BookList;
import seedu.duke.model.itemlist.LinkList;
import seedu.duke.model.itemlist.ModuleList;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.ui.Ui;

// @@author MuhammadHoze

/**
 * Clears all tasks in the task list.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Clears all tasks in the task list.\n"
            + "     Example: " + COMMAND_WORD;
    private String description = "";

    public ClearCommand(String command) {
        this.description = command;
    }

    public void execute(Model model) throws DukeException {

        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        BookList books = (BookList) model.getList(ListType.BOOK_LIST);
        LinkList links = (LinkList) model.getList(ListType.LINK_LIST);
        ModuleList modules = (ModuleList) model.getList(ListType.MODULE_LIST);

        if (description.isEmpty() | !description.equals("all")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_CLEAR);
        }
        if ((links.size() != 0 | books.size() != 0 | modules.size() != 0)) {

            tasks.clearTask();
            books.clearBook();
            links.clearList();
            modules.clearModule();
            Ui.dukePrint(Messages.MESSAGE_CLEAR);

        } else {
            throw new DukeException(Messages.MESSAGE_CLEARED);
        }
    }
}
