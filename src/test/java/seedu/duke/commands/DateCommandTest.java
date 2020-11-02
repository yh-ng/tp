package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.ItemList;
import seedu.duke.model.ListType;
import seedu.duke.model.item.Task;
import seedu.duke.model.itemlist.TaskList;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateCommandTest {

    @Test
    void execute_validDate_setsNewDate() throws DukeException {
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        argumentsMap.put("date", "13-05-2020");
        Command dateCommand = new DateCommand(1, argumentsMap);

        dateCommand.execute(model);
        assertEquals("13 May 2020", tasks.get(0).getDateString(Task.DATETIME_PRINT_FORMAT));
    }

    @Test
    void execute_invalidDate_throwsException() throws DukeException {
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        argumentsMap.put("date", "xx-yy-zzzz");
        Command dateCommand = new DateCommand(1, argumentsMap);

        assertThrows(DukeException.class, () -> {
            dateCommand.execute(model);
        });
    }

    @Test
    void execute_noDate_throwsException() throws DukeException {
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        Command dateCommand = new DateCommand(1, argumentsMap);

        assertThrows(DukeException.class, () -> {
            dateCommand.execute(model);
        });
    }
}