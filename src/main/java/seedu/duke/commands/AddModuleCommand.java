package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.ModuleList;
import seedu.duke.task.Module;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AddModuleCommand extends Command {
    public static final String COMMAND_WORD = "module";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a module to the module list.\n"
            + "     Parameters: TASK_NAME <optional arguments>\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional arguments>";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("g", "mc", "ay"));

    private final String description;
    private final HashMap<String, String> argumentsMap;

    public AddModuleCommand(String description, HashMap<String, String> argumentsMap) {
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    /**
     * Executes the command.
     *
     * @param listMap a Map object containing all lists
     */
    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        ModuleList modules = (ModuleList) listMap.get(ListType.MODULE_LIST);
        int mc;

        if (!argumentsMap.containsKey("g") || !argumentsMap.containsKey("mc") || !argumentsMap.containsKey("ay")) {
            throw new DukeException("OOPS!!! g, mc and ay arguments are required!");
        }

        try {
            mc = Integer.parseInt(argumentsMap.get("mc"));
        } catch (NumberFormatException e) {
            throw new DukeException("OOPS!!! Your MCs are invalid!");
        }

        Module module = new Module(description, argumentsMap.get("g"), mc, argumentsMap.get("ay"));
        modules.addTask(module);
    }
}
