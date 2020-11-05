package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DateCommand;
import seedu.duke.commands.SetCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    void parse_validAddCommand_returnsAddCommand() throws DukeException {
        String fullCommand = "add task tP meeting p/1";
        Command command = Parser.parse(fullCommand);
        assertTrue(command instanceof AddCommand);
    }

    @Test
    void parse_invalidAddCommand_throwsException() {
        String fullCommand = "add";
        assertThrows(DukeException.class, () -> {
            Parser.parse(fullCommand);
        });
    }

    @Test
    void parse_validSetCommand_returnsSetCommand() throws DukeException {
        String fullCommand = "set 1 p/0";
        Command command = Parser.parse(fullCommand);
        assertTrue(command instanceof SetCommand);
    }

    @Test
    void parse_invalidSetCommand_throwsException() {
        String fullCommand = "set p/-1";
        assertThrows(DukeException.class, () -> {
            Parser.parse(fullCommand);
        });
    }

    @Test
    void parse_validDateCommand_returnsDateCommand() throws DukeException {
        String fullCommand = "date 1 date/05-05-2020";
        Command command = Parser.parse(fullCommand);
        assertTrue(command instanceof DateCommand);
    }

    @Test
    void parse_invalidDateCommand_throwsException() {
        String fullCommandWrongIndex = "date a date/05-05-2020";
        assertThrows(DukeException.class, () -> {
            Parser.parse(fullCommandWrongIndex);
        });
    }

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
    void getArgumentsFromRegex_multipleBackslash_parsesCorrectly() throws DukeException {
        String testCommand = "add tP meeting p/23/24 c/cs2/1/13";
        HashMap<String, String> argumentsMap = Parser.getArgumentsFromRegex(testCommand, Parser.ARGUMENT_REGEX);
        assertEquals("23/24", argumentsMap.get("p"));
        assertEquals("cs2/1/13", argumentsMap.get("c"));
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

    @Test
    void checkAllowedArguments_argumentNotAllowed_throwsException() {
        HashSet<String> allowedArguments = new HashSet<>(Arrays.asList("p"));
        HashMap<String, String> argumentsMap = new HashMap<>();
        argumentsMap.put("p", "1");
        argumentsMap.put("i", "2");
        assertThrows(DukeException.class, () -> {
            Parser.checkAllowedArguments(argumentsMap, allowedArguments);
        });
    }
}
