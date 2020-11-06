package seedu.duke.common;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String DIVIDER = "    ____________________________________________________________";
    public static final String LOGO = "     _                           _  _   _\n"
            + "    | |                         (_)| \\ | |\n"
            + "    | |_   ___  _ __  _ __ ___   _ |  \\| | _   _  ___\n"
            + "    | __| / _ \\| '__|| '_ ` _ \\ | || . ` || | | |/ __|\n"
            + "    | |_ |  __/| |   | | | | | || || |\\  || |_| |\\__ \\\n"
            + "     \\__| \\___||_|   |_| |_| |_||_|\\_| \\_/ \\__,_||___/\n";

    public static final String MESSAGE_GOODBYE = "Farewell student. Hope to see you again soon!";
    public static final String MESSAGE_ADD_TASK = "Got it. I've added this task:\n       ";
    public static final String MESSAGE_ADD_BOOK = "Got it. I've added this book: \n";
    public static final String MESSAGE_ADD_LINK = "Got it. I've added this link:\n       ";
    public static final String MESSAGE_ADD_MODULE = "Got it. I've added this module:\n       ";

    public static final String MESSAGE_ADD_MULTIPLE_TASK = "Got it. I've added these tasks:\n       ";
    public static final String MESSAGE_STATUS_FIRST = "\n     Now you have ";

    public static final String MESSAGE_STATUS_LAST = " task(s) in the list.";
    public static final String MESSAGE_LINK_STATUS_LAST = " link(s) in the list.";
    public static final String MESSAGE_MODULE_STATUS_LAST = " module(s) in the list.";

    public static final String MESSAGE_TASK_LIST = "Here are the task(s) in your list:\n";
    public static final String MESSAGE_BOOK_LIST = "Here are the book(s) in your list:\n";
    public static final String MESSAGE_LINK_LIST = "Here are the links in your list:\n";
    public static final String MESSAGE_LIST_WITH_PRIORITY = "Here are the task(s) of this priority in your list:\n";
    public static final String MESSAGE_LIST_WITH_CATEGORY = "Here are the task(s) of this category in your list:\n";

    public static final String MESSAGE_EMPTY_TASK_LIST = "~Info~ There are no tasks in your list. "
            + "Your task list is empty.";
    public static final String MESSAGE_EMPTY_BOOK_LIST = "~Info~ There are no books in your list. "
            + "Your book list is empty.";
    public static final String MESSAGE_EMPTY_LIST_WITH_PRIORITY = "~Info~ There are no tasks of this priority in your "
            + "list. ";
    public static final String MESSAGE_EMPTY_LIST_WITH_CATEGORY = "~Info~ There are no tasks of this category in your "
            + "list. ";
    public static final String MESSAGE_EMPTY_LINK_LIST = "~Info~ There are no links in your list. "
            + "Your link list is empty.";
    public static final String MESSAGE_EMPTY_MODULE_LIST = "~Info~ There are no modules in your list. "
            + "Your module list is empty.";

    public static final String MESSAGE_DELETE = "Noted. I've removed this task:\n       ";
    public static final String MESSAGE_DELETE_TASK_WITH_PRIORITY = "Noted. I've removed all these task(s) "
            + "with the same priority:";
    public static final String MESSAGE_DELETE_TASK_WITH_CATEGORY = "Noted. I've removed all these task(s) "
            + "with the same category:";
    public static final String MESSAGE_DELETE_LINK = "Noted. I've removed this link:\n       ";
    public static final String MESSAGE_CLEAR = "Noted. I've cleared everything.";
    public static final String MESSAGE_CLEARED = "~Info~ Everything has already been cleared.";
    public static final String MESSAGE_DELETE_MODULE = "Noted. I've removed this module:\n       ";

    public static final String WARNING_NO_TASK = "~Error~ This task index does not exist. Please try again.";
    public static final String WARNING_NO_BOOK = "~Error~ This book index does not exist. Please try again.";
    public static final String WARNING_NO_LINK = "~Error~ This link index does not exist. Please try again.";
    public static final String WARNING_NO_MODULE = "~Error~ This module index does not exist. Please try again.";

    public static final String MESSAGE_DONE = "Nice! I've marked this task as done:\n       [Y] ";
    public static final String MESSAGE_RETURNED = "Nice! I've marked this book as returned:\n       [R] ";
    public static final String MESSAGE_MODULE_COMPLETE = "Nice! I've marked this module as complete:\n       ";
    public static final String MESSAGE_CATEGORY = "Nice! I have set the category of this task:\n       ";
    public static final String MESSAGE_DATE = "Nice! I have set the date of this task:\n       ";
    public static final String MESSAGE_SET_PRIORITY = "Nice! I've set the priority of this task to: ";

    public static final String MESSAGE_FIND = "Here are the matching tasks in your list:";
    public static final String MESSAGE_NOT_FOUND = "~Info~ There are no matching tasks in your list.";

    public static final String EXCEPTION_INVALID_COMMAND = "I'm sorry, but I don't know what that means. "
            + "Please enter valid commands :-(";

    public static final String EXCEPTION_DUPLICATE_ARGUMENTS = "~Error~ You have duplicate arguments! ";
    public static final String EXCEPTION_INVALID_ARGUMENTS = "~Error~ You have invalid argument(s). "
            + "Please refer to the User Guide.";
    public static final String EXCEPTION_EMPTY_DESCRIPTION = "~Error~ The description of a task cannot be empty. "
            + "Please refer to the User Guide.";
    public static final String EXCEPTION_INVALID_CATEGORY = "~Error~ Please input a valid category using the format "
            + "c/CATEGORY.";
    public static final String EXCEPTION_NEGATIVE_DAY_COUNT = "~Error~ Your number of days must be positive!";
    public static final String EXCEPTION_INVALID_DAY_COUNT = "~Error~ Your number of days is an invalid integer!";
    public static final String EXCEPTION_RECURRING_ARGUMENTS = "~Error~ All compulsory arguments (s/, e/ and day/) "
            + "are required.\n \t Please refer to the User Guide. ";

    public static final String EXCEPTION_INVALID_DATE = "~Error~ The format of your date should be DD-MM-YYYY.";
    public static final String EXCEPTION_INVALID_CLEAR = "~Error~ The command is: clear all";
    public static final String EXCEPTION_INVALID_BORROW = "~Error~ The format is: borrow <description> "
            + "<date/DD-MM-YYYY>";
    public static final String EXCEPTION_INVALID_DAY = "~Error~ The format of your day should be the first "
            + "3 characters of the day!\n"
            + "     Example: mon, tue, wed, thu, fri, sat, sun";
    public static final String EXCEPTION_INVALID_DATE_RANGE = "~Error~ Your ending date is before your starting date!";
    public static final String EXCEPTION_EMPTY_PRIORITY = "~Error~ The priority cannot be empty.";
    public static final String EXCEPTION_EMPTY_CATEGORY = "~Error~ The category cannot be empty.";
    public static final String EXCEPTION_INVALID_INDEX = "~Error~ Please input a valid task index.";
    public static final String EXCEPTION_INVALID_LINK_INDEX = "~Error~ Please input a valid link index.";
    public static final String EXCEPTION_INVALID_PRIORITY = "~Error~ Invalid priority number.";
    public static final String EXCEPTION_CATEGORY_NOT_FOUND = "~Error~ Invalid category.";

    public static final String EXCEPTION_LOAD_FILE = "The file cannot be loaded. "
            + "Maybe this is your first time using termiNus?";
    public static final String EXCEPTION_SAVE_FILE = "~Error~ Cannot save to file.";
    public static final String MESSAGE_NEW_TASK_FILE = "I have created a new tasks.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_BOOK_FILE = "I have created a new books.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_LINK_FILE = "I have created a new links.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_MODULE_FILE = "I have created a new modules.txt file for you :) "
            + "Type some commands and see it.";

    public static final String EXCEPTION_FIND = "~Error~ The keyword of a find command cannot be empty.\n "
            + "\t The format is: find <keyword>";
    public static final String EXCEPTION_LINK_TYPE = "~Error~ Please input a correct link type:\n "
            + "\t t/lecture\n"
            + "\t t/tutorial\n"
            + "\t t/lab\n"
            + "\t t/project";
    public static final String EXCEPTION_INVALID_DELETE_COMMAND = "~Error~ Please input a valid delete command "
            + "using the format: \n\n"
            + "     \"delete tasks p/PRIORITY\"\n"
            + "     \"delete tasks c/CATEGORY\"\n"
            + "     \"delete task <index number>\"\n"
            + "     \"delete link <index number>\"\n"
            + "     \"delete module <index number>\"";
    public static final String EXCEPTION_INVALID_DONE_COMMAND = "~Error~ Please input a valid done command "
            + "using the format: \n\n"
            + "     \"done task <index number>\"\n"
            + "     \"done module <index number>\"";
    public static final String EXCEPTION_INVALID_LIST_COMMAND = "~Error~ Please input a valid list command "
            + "using the format: \n\n"
            + "     \"list tasks\"\n"
            + "     \"list tasks p/PRIORITY\"\n"
            + "     \"list tasks c/CATEGORY\"\n"
            + "     \"list links\"\n"
            + "     \"list modules\"\n"
            + "     \"list books\"";
    public static final String EXCEPTION_INVALID_URL = "~Error~ Invalid url entered. Please refer to the User Guide.";
}
