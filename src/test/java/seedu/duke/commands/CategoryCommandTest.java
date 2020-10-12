package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.TaskList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryCommandTest {

    @Test
    void execute_validCategory_setsNewCategory() throws DukeException {
        String category = "test category";
        int index = 0;
        TaskList tasks = new TaskList();
        tasks.addTodo("test description");
        Command categoryCommand = new CategoryCommand(index + 1, category);
        assertEquals(null, tasks.get(index).getCategory());
        categoryCommand.execute(tasks);
        assertEquals(category, tasks.get(index).getCategory());
    }
}
