package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.ModuleList;

public class MakeFolderCommand extends Command {
    public static final String COMMAND_WORD = "makefolders";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Make folders for your modules in the modulelist";

    @Override
    public void execute(Model model) throws DukeException {
        ModuleList modules = (ModuleList) model.getList(ListType.MODULE_LIST);
        modules.createModuleFolders();
    }
}
