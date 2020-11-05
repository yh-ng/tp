package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.ListType;
import seedu.duke.model.Model;
import seedu.duke.model.itemlist.TaskList;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetCommandTest {

    @Test
    void execute_validPriority_setsNewPriority() throws DukeException {
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);

        int initialPriority = 0;
        int newPriority = 3;
        HashMap<String, String> argumentsMap = new HashMap<>();

        argumentsMap.put("p", Integer.toString(newPriority));
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertEquals(initialPriority, tasks.get(0).getPriority());
        setCommand.execute(model);
        assertEquals(newPriority, tasks.get(0).getPriority());
    }

    @Test
    void execute_negativePriority_throwsException() throws DukeException {
        int newPriority = -1;
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();
        argumentsMap.put("p", Integer.toString(newPriority));
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertThrows(DukeException.class, () -> {
            setCommand.execute(model);
        });
    }

    @Test
    void execute_invalidPriority_throwsException() throws DukeException {
        String newPriority = "a";
        Model model = new Model();
        TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        HashMap<String, String> argumentsMap = new HashMap<>();
        argumentsMap.put("p", newPriority);
        Command setCommand = new SetCommand(1, argumentsMap);

        tasks.addTodo("test description");
        assertThrows(DukeException.class, () -> {
            setCommand.execute(model);
        });
    }
}
