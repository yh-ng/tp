package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.TaskList;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetCommandTest {

    @Test
    void execute_validPriority_setsNewPriority() throws DukeException {
        Map<ListType, ItemList> listMap = new EnumMap<>(ListType.class);
        listMap.put(ListType.TASK_LIST, new TaskList());
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);

        int initialPriority = 0;
        int newPriority = 3;
        HashMap<String, String> argumentsMap = new HashMap<>();

        argumentsMap.put("p", Integer.toString(newPriority));
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertEquals(initialPriority, tasks.get(0).getPriority());
        setCommand.execute(listMap);
        assertEquals(newPriority, tasks.get(0).getPriority());
    }

    @Test
    void execute_negativePriority_throwsException() {
        int newPriority = -1;
        Map<ListType, ItemList> listMap = new EnumMap<>(ListType.class);
        listMap.put(ListType.TASK_LIST, new TaskList());
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();
        argumentsMap.put("p", Integer.toString(newPriority));
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertThrows(DukeException.class, () -> {
            setCommand.execute(listMap);
        });
    }

    @Test
    void execute_invalidPriority_throwsException() {
        String newPriority = "a";
        Map<ListType, ItemList> listMap = new EnumMap<>(ListType.class);
        listMap.put(ListType.TASK_LIST, new TaskList());
        TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();
        argumentsMap.put("p", newPriority);
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertThrows(DukeException.class, () -> {
            setCommand.execute(listMap);
        });
    }
}
