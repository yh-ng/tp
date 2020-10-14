package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    @Test
    void getArgumentsFromRegex_validCommand_parseArgumentsCorrectly() throws DukeException {
        String testCommand = "add tP meeting by/16-09-23:59 at/15-09-2020-11:00 p/1";
        HashMap<String, String> argumentsMap = Parser.getArgumentsFromRegex(testCommand, Parser.ARGUMENT_REGEX);
        assertEquals("16-09-23:59", argumentsMap.get("by"));
        assertEquals("15-09-2020-11:00", argumentsMap.get("at"));
        assertEquals("1", argumentsMap.get("p"));
    }

    @Test
    void getArgumentsFromRegex_duplicateArguments_throwsException() {
        String testCommand = "add tP meeting c/cs2113 p/1 p/2";
        assertThrows(DukeException.class, () -> {
            Parser.getArgumentsFromRegex(testCommand, Parser.ARGUMENT_REGEX);
        });
    }

    @Test
    void removeArgumentsFromCommand_validCommand_returnsDescription() {
        String testCommand = "add tP meeting by/16-09-23:59 at/15-09-2020-11:00 p/1";
        String parsedString = Parser.removeArgumentsFromCommand(testCommand, Parser.ARGUMENT_REGEX);
        String expectedString = "add tP meeting";
        assertEquals(expectedString, parsedString);
    }

    @Test
    void removeArgumentsFromCommand_noArguments_returnsDescription() {
        String testCommand = "tP meeting";
        String parsedString = Parser.removeArgumentsFromCommand(testCommand, Parser.ARGUMENT_REGEX);
        assertEquals(testCommand, parsedString);
    }

    @Test
    void removeArgumentsFromCommand_extraSpaces_trimsSpaces() {
        String testCommand = "     tP meeting   c/cs2113  p/1 ";
        String parsedString = Parser.removeArgumentsFromCommand(testCommand, Parser.ARGUMENT_REGEX);
        String expectedString = "tP meeting";
        assertEquals(expectedString, parsedString);
    }
}
