package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.ModuleList;

public class ListModuleCommand extends Command {
    @Override
    public void execute(Model model) throws DukeException {
        ModuleList modules = (ModuleList) model.getList(ListType.MODULE_LIST);
        modules.listTask();
    }
}
