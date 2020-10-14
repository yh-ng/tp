package seedu.duke.common;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String DIVIDER = "    ____________________________________________________________";
    public static final String LOGO =
            " _                           _  _   _             \n" +
            "| |                         (_)| \\ | |            \n" +
            "| |_   ___  _ __  _ __ ___   _ |  \\| | _   _  ___ \n" +
            "| __| / _ \\| '__|| '_ ` _ \\ | || . ` || | | |/ __|\n" +
            "| |_ |  __/| |   | | | | | || || |\\  || |_| |\\__ \\\n" +
            " \\__| \\___||_|   |_| |_| |_||_|\\_| \\_/ \\__,_||___/";
    public static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    public static final String MESSAGE_ADDTASK = "Got it. I've added this task:\n       ";
    public static final String MESSAGE_STATUS_FIRST = "\n     Now you have ";
    public static final String MESSAGE_STATUS_LAST = " tasks in the list.";
    public static final String MESSAGE_LIST = "Here are the tasks in your list:";
    public static final String MESSAGE_LIST_WITH_PRIORITY = "Here are the tasks of this priority in your list:";
    public static final String MESSAGE_DELETE = "Noted. I've removed this task:\n       ";
    public static final String MESSAGE_DELETE_TASK_WITH_PRIORITY = "Noted. I've removed all these task(s) "
            + "from the same priority:";
    public static final String MESSAGE_CLEAR = "Noted. I've cleared all your tasks.";
    public static final String WARNING_NO_TASK = "You do not have this task in the list.";
    public static final String MESSAGE_DONE = "Nice! I've marked this task as done:\n       [Y] ";
    public static final String MESSAGE_CATEGORY = "Nice! I have set the category of this task:\n       ";
    public static final String MESSAGE_SET_PRIORITY = "Nice! I've set the priority of this task to: ";
    public static final String EXCEPTION_INVALID_COMMAND = ":( OOPS!!! I'm sorry, but I don't know what that means. "
            + "Please enter valid commands :-(";
    public static final String EXCEPTION_EMPTY_SPACE = ";( OOPS!! Detected an empty spacing. "
            + "Please remove any unwanted spaces";
    public static final String EXCEPTION_DUPLICATE_ARGUMENTS = ";( OOPS!! You have duplicate arguments! ";
    public static final String EXCEPTION_EMPTY_DESCRIPTION = ":( OOPS!!! The description of a task cannot be empty.";
    public static final String EXCEPTION_INVALID_CATEGORY = ":( OOPS!!! Please input a valid category using the format "
            + "c/CATEGORY.";
    public static final String EXCEPTION_EMPTY_CATEGORY_BODY = ":( OOPS!!! The body of a category command cannot be "
            + "empty.";
    public static final String EXCEPTION_EMPTY_CATEGORY = ":( OOPS!!! The category cannot be empty.";
    public static final String EXCEPTION_EMPTY_DEADLINE = ":( OOPS!!! The deadline of a task cannot be empty.";
    public static final String EXCEPTION_EMPTY_TIME = ":( OOPS!!! The time of an event task cannot be empty.";
    public static final String EXCEPTION_INVALID_DEADLINE = "Please enter your deadline in the correct format.\n     "
            + "Example: deadline return book /by Sunday";
    public static final String EXCEPTION_INVALID_EVENT = "Please enter your event in the correct format.\n     "
            + "Example: event project meeting /at Mon 2-4pm";
    public static final String EXCEPTION_INVALID_INDEX = "Please input a valid task index.";
    public static final String EXCEPTION_INVALID_PRIORITY = "Invalid priority number.";
    public static final String EXCEPTION_LOAD_FILE = "The file cannot be loaded. "
            + "Maybe this is your first time using Duke?";
    public static final String EXCEPTION_SAVE_FILE = ":( OOPS!!! Cannot save to file.";
    public static final String MESSAGE_NEW_FILE = "I have created a new tasks.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String WARNING_DATETIME = "If you want your DateTime to be formatted, "
            + "you can input in this format: yyyy-MM-dd HH:mm";
    public static final String MESSAGE_FIND = "Here are the matching tasks in your list:";
    public static final String MESSAGE_NOT_FOUND = "There are no matching tasks in your list.";
    public static final String EXCEPTION_FIND = ":( OOPS!!! The keyword of a find command cannot be empty.";
    public static final String MESSAGE_EMPTY_LIST = "There are no tasks in your list. "
            + "Your task list is empty.";
    public static final String MESSAGE_EMPTY_LIST_WITH_PRIORITY = "There are no tasks of this priority in your list. ";
    public static final String EXCEPTION_INVALID_LIST_COMMAND = ":( OOPS!!! Please input a valid list command "
            + "using the format \"list p/PRIORITY\", or \"list\".";

}
