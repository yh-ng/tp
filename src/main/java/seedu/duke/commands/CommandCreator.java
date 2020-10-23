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
     * @param commandString Command parameters given by the user.
     * @param argumentsMap HashMap containing arguments.
     * @return ListCommand with given arguments.
     * @throws DukeException When invalid arguments are given.
     */
    public static Command createListCommand(String fullCommand, String commandString,
                                            HashMap<String, String> argumentsMap) throws DukeException {
        if (fullCommand.equals("list")) { //list every tasks
            return new ListCommand();
        }
        int priority;
        String category;
        if (commandString.contains("p/")) {
            if (argumentsMap.get("p") == null) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_PRIORITY);
            }
            try {
                priority = Integer.parseInt(argumentsMap.get("p"));
            } catch (NumberFormatException e) {
                throw new DukeException(Messages.EXCEPTION_INVALID_INDEX);
            }
            return new ListCommand(priority);
        } else if (commandString.contains("c/")) {
            if (argumentsMap.get("c") == null) {
                throw new DukeException(Messages.EXCEPTION_EMPTY_CATEGORY);
            }
            category = argumentsMap.get("c");
            return new ListCommand(category);
        } else {
            throw new DukeException(Messages.EXCEPTION_INVALID_LIST_COMMAND);
        }
    }

    /**
     * Creates and returns a ListCommand with given arguments.
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
}
