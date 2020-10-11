package seedu.duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodoTest {

    @Test
    void getDescription_inputDescription_returnsCorrectDescription() {
        String inputString = "test description";
        Todo todo = new Todo(inputString);
        assertEquals(inputString, todo.getDescription());
    }

    @Test
    void getIsDone_isDone_returnsFalseByDefault() {
        Todo todo = new Todo("test description");
        assertFalse(todo.getIsDone());
    }

    @Test
    void markAsDone_setIsDone_todoSetAsDone() {
        Todo todo = new Todo("test description");
        assertFalse(todo.getIsDone());
        todo.markAsDone();
        assertTrue(todo.getIsDone());
    }

    @Test
    void toFile_getToFile_returnsCorrectString() {
        Todo todo = new Todo("test description");
        String fileString = todo.toFile();
        String expectedString = "T | 0 | test description";
        assertEquals(expectedString, fileString);
    }

    @Test
    void testToString_toString_returnsCorrectString() {
        Todo todo = new Todo("test description");
        String todoString = todo.toString();
        String expectedString = "[T][N] test description (p:0)";
        assertEquals(expectedString, todoString);
    }

    @Test
    void todo_noInputPriority_setsDefaultPriority() {
        Todo todo = new Todo("test description");
        assertEquals(0, todo.getPriority());
    }

    @Test
    void setPriority_validPriority_setsCorrectPriority() {
        Todo todo = new Todo("test description");
        todo.setPriority(5);
        assertEquals(5, todo.getPriority());
    }
}
