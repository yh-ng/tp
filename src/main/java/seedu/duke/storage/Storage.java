package seedu.duke.storage;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.common.Utils;
import seedu.duke.task.Deadline;
import seedu.duke.task.Event;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.task.Todo;

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

    private String filePath;
    /** Default file path used. */
    public static final String DEFAULT_STORAGE_FILEPATH = "tasks.txt";

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
            String[] taskParts = line.split(" \\| ");
            switch (taskParts[0].trim()) {
            case "T":
                tasks.add(new Todo(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim())));
                break;
            case "E":
                tasks.add(new Event(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim()),
                        taskParts[3].trim()));
                break;
            case "D":
                tasks.add(new Deadline(taskParts[2].trim(), Utils.stringToBoolean(taskParts[1].trim()),
                        taskParts[3].trim()));
                break;
            default:
                break;
            }
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
}
