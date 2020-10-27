package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryCommandTest {

    @Test
    void execute_validCategory_setsNewCategory() throws DukeException {
        String category = "test category";
        int index = 0;
        Map<ListType, ItemList> listMap = new EnumMap<>(ListType.class);
        listMap.put(ListType.TASK_LIST, new TaskList());
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);

        tasks.addTodo("test description");
        Command categoryCommand = new CategoryCommand(index + 1, category);
        assertEquals(null, tasks.get(index).getCategory());
        categoryCommand.execute(listMap);
        assertEquals(category, tasks.get(index).getCategory());
    }
}
