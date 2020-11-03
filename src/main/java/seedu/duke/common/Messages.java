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

    public static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    public static final String MESSAGE_ADD_TASK = "Got it. I've added this task:\n       ";
    public static final String MESSAGE_ADD_BOOK = "Got it. I've added this book: ";
    public static final String MESSAGE_ADD_LINK = "Got it. I've added this link:\n       ";
    public static final String MESSAGE_ADD_NO_TASK = "There are no tasks to add.";
    public static final String MESSAGE_ADD_MULTIPLE_TASK = "Got it. I've added these tasks:\n       ";
    public static final String MESSAGE_STATUS_FIRST = "\n     Now you have ";
    public static final String MESSAGE_STATUS_LAST = " item(s) in the list.";
    public static final String MESSAGE_LINK_STATUS_FIRST = "\n     Now you have ";
    public static final String MESSAGE_LINK_STATUS_LAST = " link(s) in the list.";
    public static final String MESSAGE_MODULE_STATUS_LAST = " module(s) in the list.";
    public static final String MESSAGE_TASK_LIST = "Here are the tasks in your list:\n";
    public static final String MESSAGE_BOOK_LIST = "Here are the books in your list:\n";
    public static final String MESSAGE_LIST_WITH_PRIORITY = "Here are the tasks of this priority in your list:";
    public static final String MESSAGE_LIST_WITH_CATEGORY = "Here are the tasks of this category in your list:";
    public static final String MESSAGE_EMPTY_TASK_LIST = "There are no tasks in your list. "
            + "Your task list is empty.";
    public static final String MESSAGE_EMPTY_BOOK_LIST = "There are no books in your list. "
            + "Your book list is empty.";
    public static final String MESSAGE_EMPTY_LIST_WITH_PRIORITY = "There are no tasks of this priority in your list. ";
    public static final String MESSAGE_EMPTY_LIST_WITH_CATEGORY = "There are no tasks of this category in your list. ";
    public static final String MESSAGE_LINK_LIST = "Here are the links in your list:\n";
    public static final String MESSAGE_EMPTY_LINK_LIST = "There are no links in your list. "
            + "Your link list is empty.";
    public static final String MESSAGE_EMPTY_MODULE_LIST = "There are no modules in your list. "
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
  
    public static final String WARNING_NO_TASK = "You do not have this task in the list.";
    public static final String WARNING_NO_BOOK = "You do not have this book in the list.";
    public static final String WARNING_NO_LINK = "You do not have this link in the list.";

    public static final String MESSAGE_DONE = "Nice! I've marked this task as done:\n       [Y] ";
    public static final String MESSAGE_RETURNED = "Nice! I've marked this book as returned:\n       [R] ";
    public static final String MESSAGE_CATEGORY = "Nice! I have set the category of this task:\n       ";
    public static final String MESSAGE_DATE = "Nice! I have set the date of this task:\n       ";
    public static final String MESSAGE_SET_PRIORITY = "Nice! I've set the priority of this task to: ";

    public static final String MESSAGE_FIND = "Here are the matching tasks in your list:";
    public static final String MESSAGE_NOT_FOUND = "There are no matching tasks in your list.";

    public static final String EXCEPTION_INVALID_COMMAND = "I'm sorry, but I don't know what that means. "
            + "Please enter valid commands :-(";
    public static final String EXCEPTION_EMPTY_SPACE = "Detected an empty spacing. "
            + "Please remove any unwanted spaces";
    public static final String EXCEPTION_DUPLICATE_ARGUMENTS = "You have duplicate arguments! ";
    public static final String EXCEPTION_INVALID_ARGUMENTS = "~Error~ You have invalid arguments. "
            + "Please refer to User Guide";
    public static final String EXCEPTION_EMPTY_DESCRIPTION = "The description of a task cannot be empty.";
    public static final String EXCEPTION_EMPTY_BOOK_DESCRIPTION = ":( OOPS!!! "
            + "The description of a book cannot be empty.";
    public static final String EXCEPTION_INVALID_CATEGORY = "Please input a valid category using the format "
            + "c/CATEGORY.";
    public static final String EXCEPTION_NEGATIVE_DAY_COUNT = "Your number of days must be positive!";
    public static final String EXCEPTION_INVALID_DAY_COUNT = "Your number of days is an invalid integer!";
    public static final String EXCEPTION_RECURRING_ARGUMENTS = "You need the s/, e/ and day/ arguments!";
    public static final String EXCEPTION_EMPTY_CATEGORY_BODY = "The body of a category command cannot be "
            + "empty.";
    public static final String EXCEPTION_INVALID_DATE = "~Error~ The format of your date should be DD-MM-YYYY.";
    public static final String EXCEPTION_INVALID_CLEAR = "~Error~ The command is: clear all";
    public static final String EXCEPTION_INVALID_BORROW = "~Error~ The format is: borrow <description> "
            + "<date/DD-MM-YYYY>";
    public static final String EXCEPTION_INVALID_DAY = "The format of your day should be the first "
            + "3 characters of the day!\n"
            + "     Example: mon, tue, wed, thu, fri, sat, sun";
    public static final String EXCEPTION_EMPTY_PRIORITY = "The priority cannot be empty.";
    public static final String EXCEPTION_EMPTY_CATEGORY = "The category cannot be empty.";
    public static final String EXCEPTION_INVALID_INDEX = "Please input a valid task index.";
    public static final String EXCEPTION_INVALID_LINK_INDEX = "Please input a valid link index.";
    public static final String EXCEPTION_INVALID_PRIORITY = "Invalid priority number.";
    public static final String EXCEPTION_CATEGORY_NOT_FOUND = "Invalid category.";
    public static final String EXCEPTION_LOAD_FILE = "The file cannot be loaded. "
            + "Maybe this is your first time using termiNus?";
    public static final String EXCEPTION_SAVE_FILE = "Cannot save to file.";
    public static final String MESSAGE_NEW_TASK_FILE = "I have created a new tasks.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_BOOK_FILE = "I have created a new books.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_MEAL_CREDIT_FILE = "I have created a new mealCredit.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_LINK_FILE = "I have created a new links.txt file for you. :) "
            + "Type some commands and see it.";
    public static final String MESSAGE_NEW_MODULE_FILE = "I have created a new modules.txt file for you :) "
            + "Type some commands and see it.";
    public static final String WARNING_DATETIME = "If you want your DateTime to be formatted, "
            + "you can input in this format: YYYY-MM-DD HH:mm";
    public static final String EXCEPTION_FIND = "~Error~ The keyword of a find command cannot be empty.\n "
            + "\t The format is: find <keyword>";
    public static final String EXCEPTION_LINK_TYPE = "~Error~ Please input a correct type of lesson:\n "
            + "\t t/lecture\n"
            + "\t t/tutorial\n"
            + "\t t/lab\n"
            + "\t t/project";
    public static final String EXCEPTION_INVALID_DELETE_COMMAND = "Please input a valid delete command "
            + "using the format: \n\n"
            + "     \"delete tasks p/PRIORITY\"\n"
            + "     \"delete tasks c/CATEGORY\"\n"
            + "     \"delete task <index number>\"\n"
            + "     \"delete link <index number>\"\n"
            + "     \"delete module <index number>\"";
    public static final String EXCEPTION_INVALID_LIST_COMMAND = "Please input a valid list command "
            + "using the format: \n\n"
            + "     \"list tasks\"\n"
            + "     \"list tasks p/PRIORITY\"\n"
            + "     \"list tasks c/CATEGORY\"\n"
            + "     \"list links\"\n"
            + "     \"list modules\"\n"
            + "     \"list books\"";
    public static final String EXCEPTION_INVALID_URL = "~Error~ Please input a valid url. ";
}
