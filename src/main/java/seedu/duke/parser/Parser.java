package seedu.duke.parser;

import seedu.duke.DukeException;
import seedu.duke.commands.ByeCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeadlineCommand;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DoneCommand;
import seedu.duke.commands.EventCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.TodoCommand;
import seedu.duke.common.Messages;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses use input.
 */
public class Parser {
    public static final String ARGUMENT_REGEX = "([\\s]+[a-z]+/[:a-z0-9-]+)";

    /**
     * Parses user input into command for execution.
     *
     * @param fullCommand full user input string
     * @return the command based on the user input
     * @throws DukeException if user input commands are not in the standard format
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] words = fullCommand.split(" ", 2);
        String[] wordparts;
        switch (words[0].toLowerCase()) {
        case "todo":
            try {
                if (words[1].trim().equals("")) {
                    throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
                }
                return new TodoCommand(words[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
        case "deadline":
            try {
                wordparts = words[1].split(" /by ");
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            if (wordparts[0].trim().equals("")) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            try {
                if (wordparts[1].trim().equals("")) {
                    throw new DukeException(Messages.EXCEPTION_EMPTY_DEADLINE);
                }
                return new DeadlineCommand(wordparts[0], wordparts[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_DEADLINE);
            }
        case "event":
            try {
                wordparts = words[1].split(" /at ");
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            if (wordparts[0].trim().equals("")) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            try {
                if (wordparts[1].trim().equals("")) {
                    throw new DukeException(Messages.EXCEPTION_EMPTY_TIME);
                }
                return new EventCommand(wordparts[0], wordparts[1]);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_EVENT);
            }
        case "delete":
            try {
                return new DeleteCommand(Integer.parseInt(words[1]));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }
        case "list":
            return new ListCommand();
        case "clear":
            return new ClearCommand();
        case "done":
            try {
                return new DoneCommand(Integer.parseInt(words[1]));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }
        case "find":
            try {
                return new FindCommand(words[1].trim());
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_FIND);
            }
        case "help":
            return new HelpCommand();
        case "bye":
            return new ByeCommand();
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }

    /**
     * Parses the command and obtain arguments in the form (keyword)/(argument).
     *
     * @param fullCommand Command to be parsed.
     * @param argumentRegex The regex to match arguments against.
     * @return A HashMap of keyword-argument pairs containing the matched arguments.
     */
    public static HashMap<String, String> getArgumentsFromRegex(String fullCommand, String argumentRegex) {
        HashMap<String, String> argumentsMap = new HashMap<>();
        Pattern argumentPattern = Pattern.compile(argumentRegex);
        Matcher matcher = argumentPattern.matcher(fullCommand);

        while (matcher.find()) {
            String[] currentArgument = matcher.group().trim().split("/");
            argumentsMap.put(currentArgument[0], currentArgument[1]);
        }

        return argumentsMap;
    }

    /**
     * Removes the matching regex patterns from the input String.
     *
     * @param fullCommand String to remove regex patterns from.
     * @param argumentRegex Regex to match the String.
     * @return String with matched patterns removed.
     */
    public static String removeRegexFromArguments(String fullCommand, String argumentRegex) {
        return fullCommand.replaceAll(argumentRegex, "").trim();
    }
}
