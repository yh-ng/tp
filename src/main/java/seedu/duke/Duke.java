package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.common.Messages;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.task.ItemList;
import seedu.duke.task.LinkList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point of the Duke application.
 * Initializes the application and starts the interaction with the user.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    //private Storage linkStorage;
    private LinkList links;
    private final Map<ListType, ItemList> listMap = new EnumMap<>(ListType.class);
    private static final Logger dukeLogger = Logger.getLogger(Duke.class.getName());

    public Duke(String filePath) {
        storage = new Storage(filePath);
        //linkStorage = new Storage("links.txt");
        try {
            tasks = new TaskList(storage.load());
            //links = new LinkList(linkStorage.loadLinks());
            links = new LinkList(storage.loadLinks());
        } catch (DukeException e) {
            Ui.showError(e);
            tasks = new TaskList();
            links = new LinkList();
            Ui.dukePrint(Messages.MESSAGE_NEW_FILE);
        }
        listMap.put(ListType.TASK_LIST, tasks);
        listMap.put(ListType.LINK_LIST, links);
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
                c.execute(listMap);
                isExit = c.isExit();
                storage.save(tasks);
                storage.save(links);
            } catch (DukeException e) {
                Ui.showError(e);
            }
        }
    }
  
    public static void main(String[] args) {
        dukeLogger.log(Level.INFO,"Logging started");
        new Duke(Storage.DEFAULT_STORAGE_FILEPATH).run();
    }
}