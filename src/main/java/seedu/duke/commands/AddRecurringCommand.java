package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;

// @@author iamchenjiajun
/**
 * Represents a command that adds a recurring task to the task list.
 */
public class AddRecurringCommand extends AddCommand {
    public static final String COMMAND_WORD = "addr";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a task to the task list.\n"
            + "     Parameters: TASK_NAME <optional arguments>\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional arguments>";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p", "c", "day", "s", "e"));

    public AddRecurringCommand(String description, HashMap<String, String> argumentsMap) {
        super(description, argumentsMap);
    }

    /**
     * Executes the command.
     *
     * @param tasks a TaskList object containing all tasks
     */
    @Override
    public void execute(TaskList tasks) throws DukeException {
        final LocalDate startDate;
        final LocalDate endDate;

        if (!argumentsMap.containsKey("day") || !argumentsMap.containsKey("s") || !argumentsMap.containsKey("e")) {
            throw new DukeException(Messages.EXCEPTION_INVALID_ARGUMENTS);
        }
        try {
            startDate = LocalDate.parse(argumentsMap.get("s"), Task.DATETIME_PARSE_FORMAT);
            endDate = LocalDate.parse(argumentsMap.get("e"), Task.DATETIME_PARSE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }

        LocalDate nearestDay = findNearestDay(startDate, argumentsMap.get("day"));
        ArrayList<Task> newTasks = new ArrayList<>();

        while (nearestDay.until(endDate, ChronoUnit.DAYS) >= 0) {
            Task newTask = new Task(description);
            argumentsMap.put("date", nearestDay.format(Task.DATETIME_PARSE_FORMAT));
            setTaskProperties(newTask, argumentsMap);
            newTasks.add(newTask);
            nearestDay = nearestDay.plusDays(Calendar.DAY_OF_WEEK);
        }
        tasks.addTasksFromList(newTasks);
    }

    /**
     * Finds the nearest date from a starting date that matches the day.
     *
     * @param startDate Starting date to match.
     * @param day Day to match.
     * @return LocalDate corresponding to the nearest day.
     * @throws DukeException If none of the day matches.
     */
    private LocalDate findNearestDay(LocalDate startDate, String day) throws DukeException {
        LocalDate finalDate = startDate;
        boolean dayFound = false;
        for (int i = 0; i < Calendar.DAY_OF_WEEK; i++) {
            String startDayString = finalDate.getDayOfWeek().toString().substring(0,3).toLowerCase();
            if (startDayString.equals(day)) {
                dayFound = true;
                break;
            }
            finalDate = finalDate.plusDays(1);
        }

        if (!dayFound) {
            throw new DukeException("OOPS!!! The day you provided is invalid!");
        }

        return finalDate;
    }
}
