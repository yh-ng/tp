package seedu.duke.storage;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.model.item.Book;
import seedu.duke.model.itemlist.ItemList;
import seedu.duke.model.item.Link;
import seedu.duke.model.item.Task;
import seedu.duke.model.item.Module;

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
    /**
     * Default file path used.
     */
    public static final String TASK_STORAGE_FILEPATH = "tasks.txt";
    public static final String BOOK_STORAGE_FILEPATH = "books.txt";
    public static final String CREDIT_STORAGE_FILEPATH = "credits.txt";
    public static final String LINK_STORAGE_FILEPATH = "links.txt";
    public static final String MODULE_STORAGE_FILEPATH = "modules.txt";
    
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
        File file = new File(LINK_STORAGE_FILEPATH);
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
     * Loads the module list data from the storage.
     *
     * @return ArrayList of modules.
     * @throws DukeException If the file does not exist, or parsing errors.
     */
    public ArrayList<Module> loadModule() throws DukeException {
        File file = new File(MODULE_STORAGE_FILEPATH);
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
     * Saves the {@code ItemList} data to the storage file.
     *
     * @param items the {@code ItemList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void save(ItemList items, String saveFilePath) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(saveFilePath);
        } catch (IOException e) {
            throw new DukeException(Messages.EXCEPTION_SAVE_FILE);
        }
        String saveString = "";
        for (int i = 0; i < items.size(); i++) {
            saveString = saveString + items.get(i).toFile() + "\n";
        }
        try {
            fw.write(saveString);
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

        if (arguments.length != 5) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }

        try {
            String description = arguments[0].trim();
            String grade = arguments[1].trim();
            int mc = Integer.parseInt(arguments[2].trim());
            String semester = arguments[3].trim();
            boolean isDone = Utils.stringToBoolean(arguments[4].trim());

            return new Module(description, grade, mc, semester, isDone);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
    }
}
