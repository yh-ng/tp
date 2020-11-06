package seedu.duke.commands;

import org.apache.commons.validator.routines.UrlValidator;
import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.LinkList;
import seedu.duke.model.ListType;
import seedu.duke.model.item.Module;
import seedu.duke.model.itemlist.ModuleList;
import seedu.duke.model.itemlist.TaskList;
import seedu.duke.model.item.Link;
import seedu.duke.model.item.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// @@author iamchenjiajun

/**
 * Represents a command that adds a task to the task list.
 */
public class AddCommand extends Command {
    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a task to the task list.\n"
            + "     Parameters: TASK_NAME <optional arguments>\n"
            + "     List of <optional arguments>\n"
            + "       - p/<number> sets the priority of the task.\n"
            + "       - c/<category> sets the category of the task.\n"
            + "       - date/<dd-MM-yyyy> sets the date of the task.\n"
            + "     Example: " + COMMAND_WORD + " task" + " example_task <optional arguments>";
    public static final HashSet<String> TASK_ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p", "c", "date"));
    public static final HashSet<String> LINK_ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("m", "t", "u"));
    public static final HashSet<String> MODULE_ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("g", "mc", "ay", "d"));

    protected String description;
    protected HashMap<String, String> argumentsMap;
    private final ListType addType;

    public AddCommand(String description, HashMap<String, String> argumentsMap, ListType addType) {
        this.addType = addType;
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    @Override
    public void execute(Model model) throws DukeException {
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        LinkList links = (LinkList) model.getList(ListType.LINK_LIST);
        ModuleList modules = (ModuleList) model.getList(ListType.MODULE_LIST);

        switch (addType) {
        case TASK_LIST:
            executeAddTask(tasks);
            break;
        case LINK_LIST:
            executeAddLink(links);
            break;
        case MODULE_LIST:
            executeAddModule(modules);
            break;
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }

    private void executeAddTask(TaskList tasks) throws DukeException {
        if (description.equals("")) {
            throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
        }
        Task newTask = new Task(description);
        setTaskProperties(newTask, argumentsMap);
        tasks.addItem(newTask);
    }

    private void executeAddLink(LinkList links) throws DukeException {
        if (!argumentsMap.containsKey("m") || !argumentsMap.containsKey("t") || !argumentsMap.containsKey("u")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
        }
        String module = argumentsMap.get("m");
        String type = argumentsMap.get("t");
        if (!type.toLowerCase().equals("lecture") & !type.toLowerCase().equals("tutorial")
                & !type.toLowerCase().equals("lab") & !type.toLowerCase().equals("project")) {
            throw new DukeException(Messages.EXCEPTION_LINK_TYPE);
        }
        String url = argumentsMap.get("u");
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (!urlValidator.isValid(url)) {
            throw new DukeException(Messages.EXCEPTION_INVALID_URL);
        }
        Link newLink = new Link(module, type, url);
        links.addLink(newLink);
    }

    private void executeAddModule(ModuleList modules) throws DukeException {
        int mc;
        boolean isDone = true;

        if (!argumentsMap.containsKey("g") || !argumentsMap.containsKey("mc") || !argumentsMap.containsKey("ay")) {
            throw new DukeException("OOPS!!! g, mc and ay arguments are required!");
        }

        try {
            mc = Integer.parseInt(argumentsMap.get("mc"));
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS!!! Your MCs are invalid!");
        }

        if (argumentsMap.containsKey("d")) {
            if (!argumentsMap.get("d").equals("0") && !argumentsMap.get("d").equals("1")) {
                throw new DukeException("Your done argument is invalid! Valid values: 1 or 0.");
            }
            isDone = Utils.stringToBoolean(argumentsMap.get("d"));
        }

        Module module = new Module(description, argumentsMap.get("g"), mc, argumentsMap.get("ay"), isDone);
        modules.addModule(module);
    }

    /**
     * Sets the properties of a given Task.
     *
     * @param task         Task to set the properties of.
     * @param argumentsMap HashMap containing arguments to set the Task properties.
     * @throws DukeException If arguments in HashMap are invalid.
     */
    protected void setTaskProperties(Task task, HashMap<String, String> argumentsMap) throws DukeException {
        if (argumentsMap.containsKey("p")) {
            int newPriority;
            try {
                newPriority = Integer.parseInt(argumentsMap.get("p"));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }
            if (newPriority < 0) {
                throw new DukeException(Messages.EXCEPTION_INVALID_PRIORITY);
            }
            task.setPriority(newPriority);
        }

        if (argumentsMap.containsKey("c")) {
            if (argumentsMap.get("c") != null) {
                task.setCategory(argumentsMap.get("c"));
            }
        }

        if (argumentsMap.containsKey("date")) {
            task.setDateFromString(argumentsMap.get("date"));
        }
    }
}
