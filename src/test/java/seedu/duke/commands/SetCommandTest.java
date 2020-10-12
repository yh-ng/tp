package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.task.TaskList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetCommandTest {

    @Test
    void execute_validPriority_setsNewPriority() throws DukeException {
        int initialPriority = 0;
        int newPriority = 3;
        TaskList tasks = new TaskList();
        Command setCommand = new SetCommand(1, newPriority);

        tasks.addTodo("test description");
        assertEquals(initialPriority, tasks.get(0).getPriority());
        setCommand.execute(tasks);
        assertEquals(newPriority, tasks.get(0).getPriority());
    }

    @Test
    void execute_negativePriority_throwsException() {
        int newPriority = -1;
        TaskList tasks = new TaskList();
        Command setCommand = new SetCommand(1, newPriority);

        tasks.addTodo("test description");
        assertThrows(DukeException.class, () -> {
            setCommand.execute(tasks);
        });
    }
}
