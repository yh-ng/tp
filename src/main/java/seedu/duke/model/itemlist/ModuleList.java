package seedu.duke.model.itemlist;

import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.item.Item;
import seedu.duke.model.item.Module;
import seedu.duke.ui.Ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

// @@author iamchenjiajun
/**
 * Represents a list of modules.
 */
public class ModuleList extends ItemList<Module> {
    public ModuleList() {
        items = new ArrayList<>();
    }

    public ModuleList(ArrayList<Module> modules) {
        items = modules;
    }

    /**
     * Adds an item into the list.
     *
     * @param description the description of the item
     */
    @Override
    public void addTodo(String description) {
    }


    public void addModule(Module module) throws DukeException {
        checkModuleAlreadyExists(module);
        items.add(module);
        Ui.dukePrint(Messages.MESSAGE_ADD_MODULE + module.toString() + Messages.MESSAGE_STATUS_FIRST
                + items.size() + Messages.MESSAGE_MODULE_STATUS_LAST);
    }

    @Override
    public void deleteTask(int index) {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_MODULE);
        } else {
            Item itemRemoved = items.get(index - 1);
            Ui.dukePrint(Messages.MESSAGE_DELETE_MODULE + itemRemoved.toString() + Messages.MESSAGE_STATUS_FIRST
                    + (items.size() - 1) + Messages.MESSAGE_MODULE_STATUS_LAST);
            items.remove(index - 1);
        }
    }

    /**
     * Lists all the modules in the module list.
     */
    @Override
    public void listTask() {
        if (items.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_MODULE_LIST);
            return;
        }
        Ui.showLine();
        Ui.dukePrintMultiple("Here is a list of your module(s):\n");
        int count = 1;
        for (Module module: items) {
            Ui.dukePrintMultiple(count + "." + module.toString());
            count++;
        }

        double actualCap = computeCapFromModules(items, true);
        double projectedCap = computeCapFromModules(items, false);
        int totalMcs = computeTotalMcs(items);

        Ui.showLine();
        Ui.dukePrintMultiple(String.format("Current CAP: %.2f", actualCap));
        Ui.dukePrintMultiple(String.format("Projected CAP: %.2f", projectedCap));
        Ui.dukePrintMultiple(String.format("Total MCs completed: %d", totalMcs));
        Ui.showLine();
    }

    /**
     * Clears all the links in the list.
     */
    public void clearModule() {
        items = new ArrayList<>();

    }

    /**
     * Returns a list of graded modules from a list of modules.
     *
     * @param modules A list of modules.
     * @return A list of graded modules.
     */
    private ArrayList<Module> getGradedModules(ArrayList<Module> modules, boolean isComplete) {
        return modules.stream()
                .filter(task -> !task.getGrade().equals("S"))
                .filter(task -> !task.getGrade().equals("U"))
                .filter(task -> !isComplete || task.getIsDone())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Computes the CAP from a given list of modules.
     *
     * @param modules List of modules to compute the CAP from.
     * @return The computed CAP from the list of modules.
     */
    private double computeCapFromModules(ArrayList<Module> modules, boolean isComplete) {
        ArrayList<Module> gradedModules = getGradedModules(modules, isComplete);
        double totalGrades = 0.0;
        int totalMcs = 0;

        for (Module module : gradedModules) {
            totalMcs += module.getMc();
            totalGrades += module.getGradePoint() * module.getMc();
        }

        if (totalMcs != 0) {
            return totalGrades / totalMcs;
        } else {
            return 0.0;
        }
    }

    /**
     * Computes the total MCs from the modules.
     *
     * @param modules List of modules to compute the total MCs from.
     * @return THe computed total MCs from the list of modules.
     */
    private int computeTotalMcs(ArrayList<Module> modules) {
        return modules.stream()
                .filter(Module::getIsDone)
                .mapToInt(Module::getMc)
                .sum();
    }

    /**
     * Creates folders corresponding to the modules and academic year.
     */
    public void createModuleFolders() throws DukeException {
        Ui.showLine();
        Ui.dukePrintMultiple("Creating module folders...");

        int createdFolderCount = 0;
        for (Module module : items) {
            String academicYear = module.getSemester();
            String moduleName = module.getDescription();
            String folderName = String.format("./modules/AY%s/%s/", academicYear, moduleName);
            boolean hasCreatedFolder = new File(folderName).mkdirs();
            hasCreatedFolder |= new File(folderName + "/Lecture Notes/").mkdirs();
            hasCreatedFolder |= new File(folderName + "/Tutorial/").mkdirs();

            if (hasCreatedFolder) {
                try {
                    createdFolderCount++;
                    String filePath = new File(folderName).getCanonicalPath();
                    Ui.dukePrintMultiple("Created folder/sub-folders for " + moduleName + " at " + filePath);
                } catch (IOException e) {
                    throw new DukeException("Cannot get path");
                }
            }
        }
        Ui.dukePrintMultiple("Created folder(s) for " + createdFolderCount + " module(s).");
        Ui.showLine();
    }

    /**
     * Checks if a module with the same code and semester already exists in the module list.
     *
     * @param module Module to check against.
     * @throws DukeException If module already exists in the list.
     */
    private void checkModuleAlreadyExists(Module module) throws DukeException {
        int count = (int) items.stream()
                .filter(existingModule -> existingModule.getSemester().equals(module.getSemester()))
                .filter(existingModule -> existingModule.getDescription().equals(module.getDescription()))
                .count();
        if (count != 0) {
            throw new DukeException("~Error~ Module with same code and semester already exists!");
        }
    }

    @Override
    public void markItemAsDone(int index) {
        if (index > items.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_MODULE);
        } else {
            items.get(index - 1).markAsDone();
            Ui.dukePrint(Messages.MESSAGE_MODULE_COMPLETE + items.get(index - 1));
        }
    }
}
