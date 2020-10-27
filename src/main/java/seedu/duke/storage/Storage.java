package seedu.duke.storage;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.task.Book;
import seedu.duke.task.BookList;
import seedu.duke.task.Credit;
import seedu.duke.task.CreditList;
import seedu.duke.task.Link;
import seedu.duke.task.LinkList;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.task.Module;
import seedu.duke.task.ModuleList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used to load and save task list data.
 */
public class Storage {

    public static final int EXPECTED_DIVIDER_COUNT = 6;
    private final String filePath;
    /**
     * Default file path used.
     */
    public static final String TASK_STORAGE_FILEPATH = "tasks.txt";
    public static final String BOOK_STORAGE_FILEPATH = "books.txt";
    public static final String CREDIT_STORAGE_FILEPATH = "credits.txt";
    public static final String DEFAULT_LINK_FILEPATH = "links.txt";
    public static final String DEFAULT_MODULE_FILEPATH = "modules.txt";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the task list data from the storage, and then returns it.
     *
     * @return ArrayList of {@code Task} from the storage file.
     * @throws DukeException if the storage file does not exist, or is not a regular file.
     */
    public ArrayList<Task> loadTask() throws DukeException {
        File file = new File(TASK_STORAGE_FILEPATH);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        ArrayList<Task> tasks = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Task newTask = loadTaskFromLine(line);
            tasks.add(newTask);
        }
        return tasks;
    }

    /**
     * Loads the book list data from the storage, and then returns it.
     *
     * @return ArrayList of {@code Book} from the storage file.
     * @throws DukeException if the storage file does not exist, or is not a regular file.
     */
    public ArrayList<Book> loadBook() throws DukeException {
        File file = new File(BOOK_STORAGE_FILEPATH);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        ArrayList<Book> books = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Book newBook = loadBookFromLine(line);
            books.add(newBook);
        }
        return books;
    }

    /**
     * Loads the link list of data from the storage, and then returns it.
     *
     * @return ArrayList of {@code Link} from the storage file.
     * @throws DukeException if the storage file does not exist, or is not a regular file.
     */
    public ArrayList<Link> loadLinks() throws DukeException {
        File file = new File(DEFAULT_LINK_FILEPATH);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        ArrayList<Link> links = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Link newLink = loadLinkFromLine(line);
            links.add(newLink);
        }
        return links;
    }

    /**
     * Loads the credit list data from the storage, and then returns it.
     *
     * @return ArrayList of {@code Credit} from the storage file.
     * @throws DukeException if the storage file does not exist, or is not a regular file.
     */
    public ArrayList<Credit> loadCredit() throws DukeException {
        File file = new File(CREDIT_STORAGE_FILEPATH);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        ArrayList<Credit> mealCredit = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Credit newCredit = loadCreditFromLine(line);
            mealCredit.add(newCredit);
        }
        return mealCredit;
    }

    /**
     * Loads the module list data from the storage.
     *
     * @return ArrayList of modules.
     * @throws DukeException If the file does not exist, or parsing errors.
     */
    public ArrayList<Module> loadModule() throws DukeException {
        File file = new File(DEFAULT_MODULE_FILEPATH);
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        ArrayList<Module> modules = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Module newModule = loadModuleFromLine(line);
            modules.add(newModule);
        }
        return modules;
    }

    /**
     * Saves the list of modules to file.
     *
     * @param modules List of modules.
     * @throws DukeException If there was an error when saving.
     */
    public void saveModule(ModuleList modules) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(DEFAULT_MODULE_FILEPATH);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String taskString = "";
        for (int i = 0; i < modules.size(); i++) {
            taskString = taskString + modules.get(i).toFile() + "\n";
        }
        try {
            fw.write(taskString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }

    /**
     * Saves the {@code BookList} data to the storage file.
     *
     * @param books the {@code BookList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void saveBook(BookList books) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(BOOK_STORAGE_FILEPATH);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String bookString = "";
        for (int i = 0; i < books.size(); i++) {
            bookString = bookString + books.get(i).toFileBook() + "\n";
        }
        try {
            fw.write(bookString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }

    /**
     * Saves the {@code CreditList} data to the storage file.
     *
     * @param credits the {@code CreditList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void saveCredit(CreditList credits) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(CREDIT_STORAGE_FILEPATH);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String creditString = "";
        for (int i = 0; i < credits.size(); i++) {
            creditString = creditString + credits.get(i).toFileCredit() + "\n";
        }
        try {
            fw.write(creditString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }

    /**
     * Saves the {@code LinkList} data to the storage file.
     *
     * @param links the {@code LinkList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void save(LinkList links) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter("links.txt");
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String linkString = "";
        for (int i = 0; i < links.size(); i++) {
            linkString = linkString + links.get(i).linkToFile() + "\n";
        }
        try {
            fw.write(linkString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }

    /**
     * Saves the {@code TaskList} data to the storage file.
     *
     * @param tasks the {@code TaskList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void saveTask(TaskList tasks) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(TASK_STORAGE_FILEPATH);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String taskString = "";
        for (int i = 0; i < tasks.size(); i++) {
            taskString = taskString + tasks.get(i).toFile() + "\n";
        }
        try {
            fw.write(taskString);
            fw.close();
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
    }

    /**
     * Returns a task corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Task corresponding to the loaded line.
     * @throws DukeException If there is an error parsing the save file.
     */
    private Task loadTaskFromLine(String line) throws DukeException {
        Task newTask;
        String paddedLine = line + " ";
        String[] arguments = paddedLine.split("\\|");

        if (arguments.length != EXPECTED_DIVIDER_COUNT) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        try {
            boolean isDone = Utils.stringToBoolean(arguments[1].trim());
            String description = arguments[2].trim();
            int priority = Integer.parseInt(arguments[3].trim());
            String category = arguments[4].trim();
            String dateString = arguments[5].trim();

            newTask = new Task(description, isDone, priority);
            if (!category.equals("")) {
                newTask.setCategory(category);
            }
            if (!dateString.equals("")) {
                newTask.setDateFromString(dateString);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        return newTask;
    }

    /**
     * Returns a book corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Book corresponding to the loaded line.
     * @throws DukeException If there is an error parsing the save file.
     */
    private Book loadBookFromLine(String line) throws DukeException {
        Book newBook;
        String[] arguments = line.split("\\|");

        if (arguments.length != EXPECTED_DIVIDER_COUNT - 1) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        try {
            boolean isReturn = Utils.stringToBoolean(arguments[1].trim());
            String description = arguments[2].trim();
            String dateString = arguments[3].trim();
            String futureDateString = arguments[4].trim();

            newBook = new Book(description, isReturn);
            if (!dateString.equals("")) {
                newBook.setDateFromString(dateString);
            }
            if (!futureDateString.equals("")) {
                newBook.setDateFromString(dateString);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        return newBook;
    }

    /**
     * Returns mealCredit corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Credit corresponding to the loaded line.
     * @throws DukeException If there is an error parsing the save file.
     */
    private Credit loadCreditFromLine(String line) throws DukeException {
        Credit newCredit;
        String[] arguments = line.split("\\|");

        if (arguments.length != EXPECTED_DIVIDER_COUNT - 4) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        try {
            String description = arguments[1].trim();
            newCredit = new Credit(description);

        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        return newCredit;
    }

    /**
     * Returns a link corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Link corresponding to the loaded line.
     * @throws DukeException If there is an error parsing the save file.
     */
    private Link loadLinkFromLine(String line) throws DukeException {
        Link newLink;
        String paddedLine = line + " ";
        String[] arguments = paddedLine.split("\\|");
        try {
            String module = arguments[0].trim();
            String type = arguments[1].trim();
            String url = arguments[2].trim();
            newLink = new Link(module, type, url);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("here");
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        return newLink;
    }

    /**
     * Returns a module corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Module corresponding to the loaded line.
     * @throws DukeException If there is an error parsing the save file.
     */
    private Module loadModuleFromLine(String line) throws DukeException {
        String paddedLine = line + " ";
        String[] arguments = paddedLine.split("\\|");

        if (arguments.length != 4) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        try {
            String description = arguments[0].trim();
            String grade = arguments[1].trim();
            int mc = Integer.parseInt(arguments[2].trim());
            String semester = arguments[3].trim();

            return new Module(description, grade, mc, semester);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
    }

}
