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
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a task to the task list.\n"
            + "     Parameters: TASK_NAME <optional/compulsory arguments>\n"
            + "     List of <optional arguments>:\n"
            + "       - p/<number> sets the priority of the task.\n"
            + "       - c/<category> sets the category of the task.\n"
            + "       - date/<dd-MM-yyyy> sets the date of the task.\n"
            + "     List of `<compulsory arguments>\n"
            + "       - s/<dd-MM-yyyy> start date of recurring tasks (inclusive)\n"
            + "       - e/<dd-MM-yyyy> end date of recurring tasks (inclusive).\n"
            + "       - day/<mon/tue/wed/thu/fri/sat/sun> day of recurring task.\n"
            + "     Example: " + COMMAND_WORD + " example_task <optional arguments>";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Arrays.asList("p", "c", "day", "s", "e"));

    public AddRecurringCommand(String description, HashMap<String, String> argumentsMap) {
        super(description, argumentsMap, ListType.TASK_LIST);
    }

    @Override
    public void execute(Model model) throws DukeException {
        final TaskList tasks = (TaskList) model.getList(ListType.TASK_LIST);
        final LocalDate startDate;
        final LocalDate endDate;
        LocalDate nearestDay;
        ArrayList<Task> newTasks = new ArrayList<>();

        if (!argumentsMap.containsKey("day") || !argumentsMap.containsKey("s") || !argumentsMap.containsKey("e")) {
            throw new DukeException(Messages.EXCEPTION_RECURRING_ARGUMENTS);
        }
        try {
            startDate = LocalDate.parse(argumentsMap.get("s"), Task.DATETIME_PARSE_FORMAT);
            endDate = LocalDate.parse(argumentsMap.get("e"), Task.DATETIME_PARSE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new DukeException(Messages.EXCEPTION_INVALID_DATE);
        }

        DayOfWeek dayOfWeek = Parser.getDayFromString(argumentsMap.get("day"));
        nearestDay = startDate.with(TemporalAdjusters.nextOrSame(dayOfWeek));

        while (nearestDay.until(endDate, ChronoUnit.DAYS) >= 0) {
            Task newTask = new Task(description);
            argumentsMap.put("date", nearestDay.format(Task.DATETIME_PARSE_FORMAT));
            setTaskProperties(newTask, argumentsMap);
            newTasks.add(newTask);
            nearestDay = nearestDay.plusDays(Calendar.DAY_OF_WEEK);
        }
        tasks.addTasksFromList(newTasks);
    }
}
