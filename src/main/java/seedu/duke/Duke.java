package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.model.Model;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {
    private final Model model;
    private static final Logger dukeLogger = Logger.getLogger(Duke.class.getName());

    public Duke() {
        model = new Model();
        model.load();
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
                c.execute(model);
                isExit = c.isExit();
                model.save();
            } catch (DukeException e) {
                Ui.showError(e);
            }
        }
    }

    public static void main(String[] args) {
        dukeLogger.log(Level.INFO, "Logging started");
        new Duke().run();
    }
}
