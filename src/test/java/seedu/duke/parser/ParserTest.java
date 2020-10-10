package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    @Test
    void getArgumentsFromRegex_validCommand_parseArgumentsCorrectly() {
        String testCommand = "add tP meeting by/16-09-23:59 at/15-09-2020-11:00 p/1";
        HashMap<String, String> argumentsMap = Parser.getArgumentsFromRegex(testCommand, Parser.ARGUMENT_REGEX);
        assertEquals("16-09-23:59", argumentsMap.get("by"));
        assertEquals("15-09-2020-11:00", argumentsMap.get("at"));
        assertEquals("1", argumentsMap.get("p"));
    }

    @Test
    void removeRegexFromArguments_validCommand_returnsDescription() throws DukeException {
        String testCommand = "add tP meeting by/16-09-23:59 at/15-09-2020-11:00 p/1";
        String parsedString = Parser.removeRegexFromArguments(testCommand, Parser.ARGUMENT_REGEX);
        String expectedString = "add tP meeting";
        assertEquals(expectedString, parsedString);
    }

    @Test
    void removeRegexFromArguments_noDescription_throwsException() {
        String testCommand = " by/16-09-23:59 at/15-09-2020-11:00 p/1 ";
        assertThrows(DukeException.class, () -> {
            System.out.println(Parser.removeRegexFromArguments(testCommand, Parser.ARGUMENT_REGEX));
        });
    }
}
