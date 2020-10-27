package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;

import java.util.HashMap;

public class CommandCreator {
    /**
     * Creates and returns an AddCommand with given arguments.
     *
     * @param description  Description of the task.
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
     * @param fullCommand  Full command given by the user.
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
     * @param fullCommand    Full command given by the user.
     * @param subRootCommand sub-root command given by the user.
     * @param commandString  Command parameters given by the user.
     * @return ListCommand with given arguments.
     * @throws DukeException When invalid arguments are given.
     */
    public static Command createListCommand(String fullCommand, String subRootCommand,
                                            String commandString) throws DukeException {
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
        case "expenses":
        case "meals":
        case "books":
            return new ListCommand(false, true);
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

    public static Command createBorrowCommand(String description, HashMap<String, String> argumentsMap)
            throws DukeException {
        if (argumentsMap.isEmpty()) {
            throw new DukeException(Messages.EXCEPTION_EMPTY_DESCRIPTION);
        }
        return new BorrowCommand(description, argumentsMap);
    }


    /**
     * Creates and returns a ReturnCommand with given arguments.
     *
     * @param commandString Command parameters given by the user.
     * @return ReturnCommand with given arguments.
     * @throws DukeException If invalid arguments are given.
     */
    public static Command createReturnCommand(String commandString) throws DukeException {
        try {
            return new ReturnCommand(Integer.parseInt(commandString));
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.WARNING_NO_TASK);
        }
    }
}
