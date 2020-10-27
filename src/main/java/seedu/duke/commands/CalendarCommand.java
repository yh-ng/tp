package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

// @@author iamchenjiajun
/**
 * Represents a command corresponding to the calendar command.
 */
public class CalendarCommand extends Command {
    public static final String COMMAND_WORD = "calendar";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the date of a given task in the list."
            + "     Example: " + COMMAND_WORD + " d/<daysToPrint>\n";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("d"));

    private final HashMap<String, String> argumentsMap;
    private final LocalDate currentDate;

    public CalendarCommand(HashMap<String, String> argumentsMap) {
        this.argumentsMap = argumentsMap;
        this.currentDate = LocalDate.now();
    }

    /**
     * Executes the command.
     *
     * @param listMap a Map object containing all lists
     */
    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {
        final TaskList tasks = (TaskList) listMap.get(ListType.TASK_LIST);
        int daysToPrint;
        assert argumentsMap.size() <= ALLOWED_ARGUMENTS.size();

        if (!argumentsMap.containsKey("d")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
        }

        try {
            daysToPrint = Integer.parseInt(argumentsMap.get("d"));
            if (daysToPrint < 0) {
                throw new DukeException(Messages.EXCEPTION_NEGATIVE_DAY_COUNT);
            }
        } catch (NumberFormatException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DAY_COUNT);
        }

        ArrayList<Task> dateList = tasks.getTaskList()
                .stream()
                .filter(task -> task.getDate() != null)
                .filter(task -> currentDate.until(task.getDate(), ChronoUnit.DAYS) >= 0)
                .filter(task -> currentDate.until(task.getDate(), ChronoUnit.DAYS) <= daysToPrint)
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toCollection(ArrayList::new));
        Ui.dukePrintCalendar(currentDate, dateList, daysToPrint);
    }
}