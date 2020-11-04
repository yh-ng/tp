package seedu.duke.model.item;

import seedu.duke.DukeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// @@author iamchenjiajun
public class Module extends Item {
    public static final Pattern MODULE_CODE_PATTERN = Pattern.compile("(^[A-Z]{2,3}[\\d]{4}[A-Z]?$)");
    public static final Pattern MODULE_SEM_PATTERN = Pattern.compile("(^[\\d]{4}S[12]$)");
    public static final String MODULE_COMPLETED_STRING = "[CM]";
    public static final String MODULE_INCOMPLETE_STRING = "[IC]";

    private final String grade;
    private final double gradePoint;
    private final int mc;
    private final String semester;

    /**
     * Constructor used when adding a new task.
     * By default, the deadline task is not done.
     *
     * @param moduleCode the description of the task
     */
    public Module(String moduleCode, String grade, int mc, String semester, boolean isDone) throws DukeException {
        super(moduleCode);

        this.grade = grade;
        this.mc = mc;
        this.semester = semester;
        gradePoint = getCapFromGrade(grade);
        this.isDone = isDone;

        Matcher matcher = MODULE_CODE_PATTERN.matcher(moduleCode);
        if (!matcher.find()) {
            throw new DukeException("~Error~ Your module code is wrong!");
        }
        if (!checkValidAy(semester)) {
            throw new DukeException("~Error~ Your semester code is wrong!");
        }
        if (!checkValidMcs(mc)) {
            throw new DukeException("~Error~ Your number of MCs are invalid!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s] %s (%d MC) (AY%s)", getCompletionString(), getGrade(), getDescription(), getMc(),
                getSemester());
    }

    /**
     * Checks if the number of MCs is in a valid range.
     *
     * @param mc Number of MCs.
     * @return Boolean corresponding to the conditions.
     */
    public static boolean checkValidMcs(int mc) {
        return mc >= 0 && mc <= 40;
    }

    /**
     * Checks if the Academic Year is valid.
     *
     * @param ay Academic Year.
     * @return True if the Academic Year is valid.
     */
    public static boolean checkValidAy(String ay) {
        Matcher matcher = MODULE_SEM_PATTERN.matcher(ay);
        if (!matcher.find()) {
            return false;
        }
        assert ay.length() == 6;
        int start = Integer.parseInt(ay.substring(0, 2));
        int end = Integer.parseInt(ay.substring(2, 4));
        return end - start == 1;
    }

    /**
     * Converts the attributes of the task into a formatted string to be saved into the storage file.
     *
     * @return the formatted string to be saved into the storage file
     */
    @Override
    public String toFile() {
        String isDoneString = (isDone) ? "1" : "0";
        return getDescription() + " | " + getGrade() + " | " + getMc() + " | " + getSemester() + " | " + isDoneString;
    }

    public int getMc() {
        return mc;
    }

    public String getGrade() {
        return grade;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public String getSemester() {
        return semester;
    }

    public String getCompletionString() {
        return (isDone) ? MODULE_COMPLETED_STRING : MODULE_INCOMPLETE_STRING;
    }

    private double getCapFromGrade(String grade) throws DukeException {
        switch (grade) {
        case "A+":
            // Fallthrough
        case "A":
            return 5.0;
        case "A-":
            return 4.5;
        case "B+":
            return 4.0;
        case "B":
            return 3.5;
        case "B-":
            return 3.0;
        case "C+":
            return 2.5;
        case "C":
            return 2.0;
        case "D+":
            return 1.5;
        case "D":
            return 1.0;
        case "S":
            // Fallthrough
        case "U":
            // Fallthrough
        case "F":
            return 0.0;
        default:
            throw new DukeException("~Error~ Invalid grade!");
        }
    }
}
