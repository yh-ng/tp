package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;

import java.util.HashMap;

public class CommandCreator {
    /**
     * Creates and returns an AddCommand with given arguments.
     *
     * @param description Description of the task.
     * @param argumentsMap HashMap containing optional arguments.
     * @return AddCommand with given arguments.
     * @throws DukeException When description is empty.
     */
    public static Command createAddCommand(String description, HashMap<String, String> argumentsMap)
            throws DukeException {
        if (description.equals("")) {
            throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
        }
        return new AddCommand(description, argumentsMap);
    }

    public static Command createAddCommand(String commandString) throws DukeException {
        if (!commandString.contains("m/") || !commandString.contains(" t/") || !commandString.contains(" u/")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_COMMAND);
        }
        int indexOfT = commandString.indexOf("t/");
        String module = commandString.substring(2, indexOfT - 1);
        int indexOfU = commandString.indexOf("u/");
        String type = commandString.substring(indexOfT + 2, indexOfU - 1);
        String url = commandString.substring(indexOfU + 2);
        return new AddCommand(module, type, url);
    }

    public static Command parseAddCommand(String commandString, String description, HashMap<String,
            String> argumentsMap) throws DukeException {
        String subRootAddCommand = commandString.split(" ")[0];
        if (subRootAddCommand.equals("link")) {
            commandString = commandString.replaceFirst(subRootAddCommand, "").trim();
            return CommandCreator.createAddCommand(commandString);
        } else {
            //checkAllowedArguments(argumentsMap, AddCommand.ALLOWED_ARGUMENTS);
            for (HashMap.Entry<String, String> entry : argumentsMap.entrySet()) {
                if (!AddCommand.ALLOWED_ARGUMENTS.contains(entry.getKey())) {
                    throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
                }
            }
            return CommandCreator.createAddCommand(description, argumentsMap);
        }
    }

    public static Command createAddRecurringCommand(String description, HashMap<String, String> argumentsMap)
            throws DukeException {
        if (description.equals("")) {
            throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
        }
        return new AddRecurringCommand(description, argumentsMap);
    }

    /**
     * Creates and returns a SetCommand with given arguments.
     *
     * @param fullCommand Full command given by the user.
     * @param argumentsMap HashMap containing optional arguments.
     * @return SetCommand with given arguments.
     * @throws DukeException When invalid arguments are given.
     */
    public static Command createSetCommand(String fullCommand, HashMap<String, String> argumentsMap)
            throws DukeException {
        try {
            return new SetCommand(Integer.parseInt(fullCommand.split(" ")[1]), argumentsMap);
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.WARNING_NO_TASK);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
        }
    }

    /**
     * Creates and returns a ListCommand with given arguments.
     *
     * @param fullCommand Full command given by the user.
     * @param subRootCommand sub-root command given by the user.
     * @param commandString Command parameters given by the user.
     * @return ListCommand with given arguments.
     * @throws DukeException When invalid arguments are given.
     */
    public static Command createListCommand(String fullCommand, String subRootCommand,
                                            String commandString) throws DukeException {
        if (fullCommand.trim().toLowerCase().equals("list")) {
            return new ListCommand();
        }
        if (fullCommand.trim().toLowerCase().equals("list tasks sorted")) {
            return new ListCommand(true, false);
        }
        switch (subRootCommand.toLowerCase()) {
        case "tasks":
            if (commandString.length() == 0) {
                return new ListCommand();
            }
            int priority;
            String category;
            if (commandString.contains("p/")) {
                if (commandString.length() == 2) {
                    throw new DukeException(Messages.EXCEPTION_EMPTY_PRIORITY);
                }
                try {
                    priority = Integer.parseInt(commandString.substring(2));
                } catch (NumberFormatException e) {
                    throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
                }
                return new ListCommand(priority);
            } else if (commandString.contains("c/")) {
                if (commandString.length() == 2) {
                    throw new DukeException(Messages.EXCEPTION_EMPTY_CATEGORY);
                }
                category = commandString.substring(2);
                return new ListCommand(category);
            } else {
                throw new DukeException(Messages.EXCEPTION_INVALID_LIST_COMMAND);
            }
        case "links":
            return new ListCommand(false,true);
        case "expenses":
        case "meals":
        default:
            throw new DukeException(Messages.EXCEPTION_INVALID_LIST_COMMAND);
        }
    }

    /**
     * Creates and returns a DeleteCommand with given arguments.
     *
     * @param commandString Command parameters given by the user.
     * @return DeleteCommand with given arguments.
     * @throws DukeException When invalid arguments are given.
     */
    public static Command createDeleteCommand(String commandString) throws DukeException {
        try {
            if (commandString.contains("p")) { // for priority
                return new DeleteCommand(commandString);
            } else if (commandString.contains("c")) { // for category
                return new DeleteCommand(commandString);
            } else {
                return new DeleteCommand(Integer.parseInt(commandString));
            }
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);

        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.WARNING_NO_TASK);
        }
    }

    /**
     * Creates and returns a DateCommand with given arguments.
     *
     * @param commandString Command parameters given by the user.
     * @return DateCommand with given arguments.
     * @throws DukeException If invalid arguments are given.
     */
    public static Command createDateCommand(String commandString, HashMap<String, String> argumentsMap)
            throws DukeException {
        try {
            int index = Integer.parseInt(commandString.split(" ")[0]);
            return new DateCommand(index, argumentsMap);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
        }
    }

    /**
     * Creates and returns a DoneCommand with given arguments.
     *
     * @param commandString Command parameters given by the user.
     * @return DoneCommand with given arguments.
     * @throws DukeException If invalid arguments are given.
     */
    public static Command createDoneCommand(String commandString) throws DukeException {
        try {
            return new DoneCommand(Integer.parseInt(commandString));
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.WARNING_NO_TASK);
        }
    }

    public static Command createFindCommand(String commandString) throws DukeException {
        try {
            return new FindCommand(commandString.trim());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_FIND);
        }
    }
}
