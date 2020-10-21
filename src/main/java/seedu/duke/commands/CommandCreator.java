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
}
