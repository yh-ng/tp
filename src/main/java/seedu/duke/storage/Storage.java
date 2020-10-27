package seedu.duke.storage;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.task.Link;
import seedu.duke.task.LinkList;
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
    /** Default file path used. */
    public static final String DEFAULT_STORAGE_FILEPATH = "tasks.txt";
    public static final String DEFAULT_LINK_FILEPATH = "lists.txt";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads the task list data from the storage, and then returns it.
     *
     * @return ArrayList of {@code Task} from the storage file.
     * @throws DukeException if the storage file does not exist, or is not a regular file.
     */
    public ArrayList<Task> load() throws DukeException {
        File file = new File(filePath);
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
     * Saves the {@code TaskList} data to the storage file.
     *
     * @param tasks the {@code TaskList} to be saved to the storage file
     * @throws DukeException if there were errors storing data to file.
     */
    public void save(TaskList tasks) throws DukeException {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
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

    private Link loadLinkFromLine(String line) throws DukeException {
        Link newLink;
        String paddedLine = line + " ";
        String[] arguments = paddedLine.split("\\|");
        try {
            String module = arguments[1].trim();
            String type = arguments[2].trim();
            String url = arguments[3].trim();
            newLink = new Link(module, type, url);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Messages.EXCEPTION_LOAD_FILE);
        }
        return newLink;
    }

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
}
