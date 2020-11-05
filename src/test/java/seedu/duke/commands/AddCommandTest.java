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

class AddCommandTest {

    @Test
    void execute_validCommand_addsTodo() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        assertEquals(1, taskList.size());
        assertEquals(description, taskList.get(0).getDescription());
    }

    @Test
    void execute_validCommandWithPriority_addsTodoWithPriority() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputPriority = "2";
        argumentsMap.put("p", inputPriority);
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        assertEquals(1, taskList.size());
        assertEquals(Integer.parseInt(inputPriority), taskList.get(0).getPriority());
    }

    @Test
    void execute_validCommandWithCategory_addsTodoWithCategory() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputCategory = "cs2113";
        argumentsMap.put("c", inputCategory);
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        assertEquals(1, taskList.size());
        assertEquals(inputCategory, taskList.get(0).getCategory());
    }

    @Test
    void execute_commandWithInvalidPriority_throwsException() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputPriority = "-2";
        argumentsMap.put("p", inputPriority);
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        });

        inputPriority = "a";
        argumentsMap.put("p", inputPriority);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        });
    }

    @Test
    void execute_commandWithDate_addsCommandWithDate() throws DukeException {
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputDate = "13-05-2020";
        String expectedDateString = "13 May 2020";
        argumentsMap.put("date", inputDate);

        new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        assertEquals(expectedDateString, taskList.get(0).getDateString(Task.DATETIME_PRINT_FORMAT));
    }

    @Test
    void execute_commandWithInvalidDate_throwsException() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        Model model = new Model();
        TaskList taskList = (TaskList) model.getList(ListType.TASK_LIST);

        String inputDate = "13-13-2020";
        argumentsMap.put("date", inputDate);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        });

        inputDate = "blah";
        argumentsMap.put("date", inputDate);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap, ListType.TASK_LIST).execute(model);
        });
    }
}