package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.TaskList;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCommandTest {

    @Test
    void execute_validCommand_addsTodo() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        TaskList taskList = new TaskList();

        new AddCommand(description, argumentsMap).execute(taskList);
        assertEquals(1, taskList.size());
        assertEquals(description, taskList.get(0).getDescription());
    }

    @Test
    void execute_validCommandWithPriority_addsTodoWithPriority() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputPriority = "2";
        argumentsMap.put("p", inputPriority);
        TaskList taskList = new TaskList();

        new AddCommand(description, argumentsMap).execute(taskList);
        assertEquals(1, taskList.size());
        assertEquals(Integer.parseInt(inputPriority), taskList.get(0).getPriority());
    }

    @Test
    void execute_validCommandWithCategory_addsTodoWithCategory() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputCategory = "cs2113";
        argumentsMap.put("c", inputCategory);
        TaskList taskList = new TaskList();

        new AddCommand(description, argumentsMap).execute(taskList);
        assertEquals(1, taskList.size());
        assertEquals(inputCategory, taskList.get(0).getCategory());
    }

    @Test
    void execute_commandWithInvalidPriority_throwsException() {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputPriority = "-2";
        argumentsMap.put("p", inputPriority);
        TaskList taskList = new TaskList();

        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap).execute(taskList);
        });

        inputPriority = "a";
        argumentsMap.put("p", inputPriority);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap).execute(taskList);
        });
    }

    @Test
    void execute_commandWithDate_addsCommandWithDate() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        String inputDate = "13-05-2020";
        String expectedDateString = "May 13 2020";
        argumentsMap.put("date", inputDate);
        TaskList taskList = new TaskList();

        new AddCommand(description, argumentsMap).execute(taskList);
        assertEquals(expectedDateString, taskList.get(0).getDateString());
    }

    @Test
    void execute_commandWithInvalidDate_throwsException() throws DukeException {
        String description = "test description";
        HashMap<String, String> argumentsMap = new HashMap<>();
        TaskList taskList = new TaskList();

        String inputDate = "13-13-2020";
        argumentsMap.put("date", inputDate);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap).execute(taskList);
        });

        inputDate = "blah";
        argumentsMap.put("date", inputDate);
        assertThrows(DukeException.class, () -> {
            new AddCommand(description, argumentsMap).execute(taskList);
        });
    }
}