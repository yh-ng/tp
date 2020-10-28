package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.ModuleList;

import java.util.Map;

public class ListModuleCommand extends Command {

    /**
     * Executes the command.
     *
     * @param listMap a TaskList object containing all tasks
     */
    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        ModuleList modules = (ModuleList) listMap.get(ListType.MODULE_LIST);
        modules.listTask();
    }
}
