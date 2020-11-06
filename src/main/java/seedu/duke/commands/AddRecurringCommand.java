package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.Model;
import seedu.duke.parser.Parser;
import seedu.duke.model.ListType;
import seedu.duke.model.item.Task;
import seedu.duke.model.itemlist.TaskList;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
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
    public static final String MESSAGE_DESCRIPTION = COMMAND_WORD
            + ": Adds multiple tasks to the list of tasks that occur weekly on a given day.\n";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds multiple tasks to the list of tasks that occur weekly on a given day.\n"
            + "     Parameters: TASK_NAME <optional/compulsory arguments>\n"
            + "     List of <optional arguments>:\n"
            + "       - p/<number> sets the priority of the task.\n"
            + "       - c/<category> sets the category of the task.\n"
            + "       - date/<dd-MM-yyyy> sets the date of the task.\n"
            + "     List of <compulsory arguments>\n"
            + "       - s/<dd-MM-yyyy> start date of recurring tasks (inclusive)\n"
            + "       - e/<dd-MM-yyyy> end date of recurring tasks (inclusive).\n"
            + "       - day/<mon/tue/wed/thu/fri/sat/sun> day of recurring task.\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional/compulsory arguments>";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p", "c", "day", "s", "e"));

    public AddRecurringCommand(String description, HashMap<String, String> argumentsMap) {
        super(description, argumentsMap, ListType.TASK_LIST);
    }

    @Override
    public void execute(Model model) throws DukeException {
        final TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        final LocalDate startDate;
        final LocalDate endDate;
        LocalDate firstDate;
        DayOfWeek dayOfWeek;

        if (!argumentsMap.containsKey("day") || !argumentsMap.containsKey("s") || !argumentsMap.containsKey("e")) {
            throw new DukeException(Messages.EXCEPTION_RECURRING_ARGUMENTS);
        }
        try {
            startDate = LocalDate.parse(argumentsMap.get("s"), Task.DATETIME_PARSE_FORMAT);
            endDate = LocalDate.parse(argumentsMap.get("e"), Task.DATETIME_PARSE_FORMAT);
            dayOfWeek = Parser.getDayFromString(argumentsMap.get("day"));
            firstDate = startDate.with(TemporalAdjusters.nextOrSame(dayOfWeek));
        } catch (DateTimeParseException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }
        if (endDate.isBefore(startDate)) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE_RANGE);
        }

        ArrayList<Task> newTasks = generateWeeklyTasks(firstDate, endDate);
        if (newTasks.size() == 0) {
            throw new DukeException("There is no " + dayOfWeek + " between " + startDate + " and " + endDate + "!");
        }
        tasks.addTasksFromList(newTasks);
    }

    /**
     * Generates a list of Tasks every 7 days from a starting date to an end date.
     * 
     * @param firstDate Starting date to generate tasks.
     * @param endDate End date of tasks.
     * @return ArrayList of Tasks between starting date and ending date.
     * @throws DukeException If Tasks have invalid arguments.
     */
    private ArrayList<Task> generateWeeklyTasks(LocalDate firstDate, LocalDate endDate) throws DukeException {
        ArrayList<Task> newTasks = new ArrayList<>();
        while (firstDate.until(endDate, ChronoUnit.DAYS) >= 0) {
            Task newTask = new Task(description);
            argumentsMap.put("date", firstDate.format(Task.DATETIME_PARSE_FORMAT));
            setTaskProperties(newTask, argumentsMap);
            newTasks.add(newTask);
            firstDate = firstDate.plusDays(Calendar.DAY_OF_WEEK);
        }
        return newTasks;
    }
}
