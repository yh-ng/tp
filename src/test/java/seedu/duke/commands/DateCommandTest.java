package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateCommandTest {

    @Test
    void execute_validDate_setsNewDate() throws DukeException {
        TaskList tasks = new TaskList();
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        argumentsMap.put("date", "13-05-2020");
        Command dateCommand = new DateCommand(1, argumentsMap);

        dateCommand.execute(tasks);
        assertEquals("13 May 2020", tasks.get(0).getDateString(Task.DATETIME_PRINT_FORMAT));
    }

    @Test
    void execute_invalidDate_throwsException() {
        TaskList tasks = new TaskList();
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        argumentsMap.put("date", "xx-yy-zzzz");
        Command dateCommand = new DateCommand(1, argumentsMap);

        assertThrows(DukeException.class, () -> {
            dateCommand.execute(tasks);
        });
    }

    @Test
    void execute_noDate_throwsException() {
        TaskList tasks = new TaskList();
        HashMap<String, String> argumentsMap = new HashMap<>();

        tasks.addTodo("test description");
        Command dateCommand = new DateCommand(1, argumentsMap);

        assertThrows(DukeException.class, () -> {
            dateCommand.execute(tasks);
        });
    }
}