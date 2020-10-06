package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;

    public Duke(String filePath) {
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            Ui.showError(e);
            tasks = new TaskList();
            Ui.dukePrint(Messages.MESSAGE_NEW_FILE);
        }
    }

    /**
     * Reads the user command and executes it, until the user issues the bye command.
     */
    public void run() {
        Ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = Ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks);
                isExit = c.isExit();
                storage.save(tasks);
            } catch (DukeException e) {
                Ui.showError(e);
            }
        }
    }

    public static void main(String[] args) {
        new Duke(Storage.DEFAULT_STORAGE_FILEPATH).run();
    }
}