package seedu.duke.parser;

import seedu.duke.DukeException;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.AddRecurringCommand;
import seedu.duke.commands.BorrowCommand;
import seedu.duke.commands.ByeCommand;
import seedu.duke.commands.CalendarCommand;
import seedu.duke.commands.CategoryCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.CommandCreator;
import seedu.duke.commands.DateCommand;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DoneCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.MakeFolderCommand;
import seedu.duke.commands.ReturnCommand;
import seedu.duke.commands.SetCommand;
import seedu.duke.common.Messages;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parses user input.
 */
public class Parser {
    public static final String ARGUMENT_REGEX = "([\\w]+/[^\\s]+)";
    public static final Logger parserLogger = Logger.getLogger(Parser.class.getName());
    public static final Pattern argumentPattern = Pattern.compile(ARGUMENT_REGEX);

    /**
     * Parses user input into command for execution.
     *
     * @param fullCommand full user input string
     * @return the command based on the user input
     * @throws DukeException if user input commands are not in the standard format
     */
    public static Command parse(String fullCommand) throws DukeException {
        String rootCommand = fullCommand.split(" ")[0];
        String commandString = fullCommand.replaceFirst(rootCommand, "").trim();
        String description = removeArgumentsFromCommand(commandString, ARGUMENT_REGEX);
        HashMap<String, String> argumentsMap = getArgumentsFromRegex(commandString, ARGUMENT_REGEX);
        checkValidDescription(description);

        switch (rootCommand.toLowerCase()) {
        case AddCommand.COMMAND_WORD:
            return CommandCreator.createAddCommand(commandString, description, argumentsMap);
        case AddRecurringCommand.COMMAND_WORD:
            checkAllowedArguments(argumentsMap, AddRecurringCommand.ALLOWED_ARGUMENTS);
            return CommandCreator.createAddRecurringCommand(description, argumentsMap);
        case SetCommand.COMMAND_WORD:
            checkAllowedArguments(argumentsMap, SetCommand.ALLOWED_ARGUMENTS);
            return CommandCreator.createSetCommand(fullCommand, argumentsMap);
        case DateCommand.COMMAND_WORD:
            checkAllowedArguments(argumentsMap, DateCommand.ALLOWED_ARGUMENTS);
            return CommandCreator.createDateCommand(commandString, argumentsMap);
        case CalendarCommand.COMMAND_WORD:
            checkAllowedArguments(argumentsMap, CalendarCommand.ALLOWED_ARGUMENTS);
            return new CalendarCommand(argumentsMap);
        case CategoryCommand.COMMAND_WORD:
            return CommandCreator.createCategoryCommand(commandString, argumentsMap);
        case ListCommand.COMMAND_WORD:
            String subRootCommand = commandString.split(" ")[0];
            commandString = commandString.replaceFirst(subRootCommand, "").trim();
            return CommandCreator.createListCommand(fullCommand, subRootCommand, commandString);
        case DeleteCommand.COMMAND_WORD:
            return CommandCreator.createDeleteCommand(commandString);
        case BorrowCommand.COMMAND_WORD:
            checkAllowedArguments(argumentsMap, BorrowCommand.ALLOWED_ARGUMENTS);
            return CommandCreator.createBorrowCommand(description, argumentsMap);
        case ClearCommand.COMMAND_WORD:
            return new ClearCommand(commandString);
        case DoneCommand.COMMAND_WORD:
            return CommandCreator.createDoneCommand(commandString);
        case ReturnCommand.COMMAND_WORD:
            return CommandCreator.createReturnCommand(commandString);
        case FindCommand.COMMAND_WORD:
            return CommandCreator.createFindCommand(commandString);
        case MakeFolderCommand.COMMAND_WORD:
            return new MakeFolderCommand();
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();
        case ByeCommand.COMMAND_WORD:
            return new ByeCommand();
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
    }

    // @@author iamchenjiajun
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
        StringBuilder log = new StringBuilder("Optional arguments: ");
        Matcher matcher = argumentPattern.matcher(argumentString);

        if (!matcher.find()) {
            return argumentsMap;
        }

        int argumentStartIndex = matcher.start();
        String optionalArgumentString = argumentString.substring(argumentStartIndex).trim();
        String[] arguments = optionalArgumentString.trim().split(" ");

        for (String argument: arguments) {
            if (argument.isEmpty()) {
                continue;
            }
            log.append(argument).append(" ");
            if (!argumentPattern.matcher(argument).find()) {
                throw new DukeException("'" + argument + "' is not a valid argument!");
            }
            String argumentKey = argument.split("/", 2)[0];
            String argumentValue = argument.split("/", 2)[1];
            if (argumentsMap.containsKey(argumentKey)) {
                throw new DukeException(Messages.EXCEPTION_DUPLICATE_ARGUMENTS);
            }
            argumentsMap.put(argumentKey, argumentValue);
        }

        parserLogger.log(Level.FINER, log.toString());
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
        Matcher matcher = argumentPattern.matcher(argumentString);
        String description = argumentString.replaceAll(argumentRegex, "").trim();

        if (matcher.find()) {
            int argumentStartIndex = matcher.start();
            description = argumentString.substring(0, argumentStartIndex).trim();
        }

        parserLogger.log(Level.FINER, "Description: " + description);
        return description;
    }

    /**
     * Checks if the user passed in an invalid optional argument for a given command.
     *
     * @param argumentsMap     HashMap containing optional arguments.
     * @param allowedArguments HashSet containing allowed arguments.
     * @throws DukeException If argumentsMap contains invalid arguments not in allowedArguments.
     */
    public static void checkAllowedArguments(HashMap<String, String> argumentsMap, HashSet<String> allowedArguments)
            throws DukeException {
        for (HashMap.Entry<String, String> entry : argumentsMap.entrySet()) {
            if (!allowedArguments.contains(entry.getKey())) {
                throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
            }
        }
    }

    /**
     * Checks if the description contains illegal characters.
     *
     * @param description Description given by the user.
     * @throws DukeException If the description contains illegal characters.
     */
    public static void checkValidDescription(String description) throws DukeException {
        if (description.contains("/")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
        }
    }

    /**
     * Parses a day string and returns a DayOfWeek enum corresponding to the day of the week.
     *
     * @param day String of the day to parse.
     * @return DayOfWeek enum representing the corresponding day of the week.
     * @throws DukeException If the string is invalid.
     */
    public static DayOfWeek getDayFromString(String day) throws DukeException {
        switch (day.toLowerCase()) {
        case "mon":
            return DayOfWeek.MONDAY;
        case "tue":
            return DayOfWeek.TUESDAY;
        case "wed":
            return DayOfWeek.WEDNESDAY;
        case "thu":
            return DayOfWeek.THURSDAY;
        case "fri":
            return DayOfWeek.FRIDAY;
        case "sat":
            return DayOfWeek.SATURDAY;
        case "sun":
            return DayOfWeek.SUNDAY;
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_DAY);
        }
    }
}
