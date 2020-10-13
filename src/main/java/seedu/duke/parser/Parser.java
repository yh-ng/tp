package seedu.duke.parser;

import seedu.duke.DukeException;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.ByeCommand;
import seedu.duke.commands.CategoryCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DoneCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.SetCommand;
import seedu.duke.common.Messages;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses use input.
 */
public class Parser {
    public static final String ARGUMENT_REGEX = "([a-z]+/[:a-z0-9-]+)";

    /**
     * Parses user input into command for execution.
     *
     * @param fullCommand full user input string
     * @return the command based on the user input
     * @throws DukeException if user input commands are not in the standard format
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] words = fullCommand.split(" ", 2);
        String commandString = fullCommand.replaceFirst(words[0], "").trim();
        String description = removeArgumentsFromCommand(commandString, ARGUMENT_REGEX);
        HashMap<String, String> argumentsMap = getArgumentsFromRegex(commandString, ARGUMENT_REGEX);

        switch (words[0].toLowerCase()) {
        case AddCommand.COMMAND_WORD:
            if (description.equals("")) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
            }
            return new AddCommand(description, argumentsMap);


        case CategoryCommand.COMMAND_WORD:
            int index;
            try {
                index = Integer.parseInt(commandString.split(" ")[0]);
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }
            if (!argumentsMap.containsKey("c")) {
                throw new DukeException(Messages.EXCEPTION_INVALID_CATEGORY);
            }
            if (argumentsMap.get("c").trim().equals("")) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_CATEGORY);
            }
            return new CategoryCommand(index, argumentsMap.get("c"));


        case ListCommand.COMMAND_WORD:
            if (words.length == 1) {
                return new ListCommand();
            }
            int priority;
            if (!commandString.contains("p/")) {
                throw new DukeException(Messages.EXCEPTION_INVALID_LIST_COMMAND);
            }
            if (argumentsMap.get("p") == null) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_CATEGORY);
            }
            try {
                priority = Integer.parseInt(argumentsMap.get("p"));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }
            return new ListCommand(priority);


        case DeleteCommand.COMMAND_WORD:
            try {
                if (words[1].contains("p")) {
                    return new DeleteCommand(words[1]);
                } else {
                    return new DeleteCommand(Integer.parseInt(words[1]));
                }
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);

            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }
  
  
        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();


        case DoneCommand.COMMAND_WORD:
            try {
                return new DoneCommand(Integer.parseInt(words[1]));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.WARNING_NO_TASK);
            }


        case FindCommand.COMMAND_WORD:
            try {
                return new FindCommand(words[1].trim());
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException(Messages.EXCEPTION_FIND);
            }


        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();


        case SetCommand.COMMAND_WORD:
            try {
                return new SetCommand(Integer.parseInt(fullCommand.split(" ")[1]),
                        Integer.parseInt(argumentsMap.get("p")));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }


        case ByeCommand.COMMAND_WORD:
            return new ByeCommand();


        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }

    /**
     * Parses the command and obtain arguments in the form (keyword)/(argument).
     *
     * @param argumentString Command substring to be parsed.
     * @param argumentRegex  The regex to match arguments against.
     * @return A HashMap of keyword-argument pairs containing the matched arguments.
     */
    public static HashMap<String, String> getArgumentsFromRegex(String argumentString, String argumentRegex)
            throws DukeException {
        HashMap<String, String> argumentsMap = new HashMap<>();
        Pattern argumentPattern = Pattern.compile(argumentRegex);
        Matcher matcher = argumentPattern.matcher(argumentString);

        while (matcher.find()) {
            String[] currentArgument = matcher.group().trim().split("/");
            if (argumentsMap.containsKey(currentArgument[0])) {
                throw new DukeException(Messages.EXCEPTION_DUPLICATE_ARGUMENTS);
            }
            argumentsMap.put(currentArgument[0], currentArgument[1]);
        }

        return argumentsMap;
    }

    /**
     * Removes arguments from the command string.
     *
     * @param argumentString Command substring to remove arguments from.
     * @param argumentRegex  Regex to match the arguments.
     * @return String with matched patterns removed.
     */
    public static String removeArgumentsFromCommand(String argumentString, String argumentRegex) {
        Pattern argumentPattern = Pattern.compile(argumentRegex);
        Matcher matcher = argumentPattern.matcher(argumentString);
        String description = argumentString.replaceAll(argumentRegex, "").trim();

        if (matcher.find()) {
            int argumentStartIndex = matcher.start();
            description = argumentString.substring(0, argumentStartIndex).trim();
        }

        return description;
    }
}
