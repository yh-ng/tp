package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.ItemList;
import seedu.duke.model.ListType;
import seedu.duke.model.itemlist.TaskList;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryCommandTest {

    @Test
    void execute_validCategory_setsNewCategory() throws DukeException {
        String category = "test category";
        int index = 0;
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);

        tasks.addTodo("test description");
        Command categoryCommand = new CategoryCommand(index + 1, category);
        assertEquals(null, tasks.get(index).getCategory());
        categoryCommand.execute(model);
        assertEquals(category, tasks.get(index).getCategory());
    }
}
