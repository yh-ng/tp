package seedu.duke.storage;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.task.Book;
import seedu.duke.task.BookList;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;

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
     * Returns a task corresponding to arguments from a line loaded from file.
     *
     * @param line A line loaded from the save file.
     * @return Task corresponding to the loaded line.
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
}
