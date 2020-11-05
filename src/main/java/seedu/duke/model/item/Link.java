// @@author Cao-Zeyu

package seedu.duke.model.item;

import seedu.duke.DukeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Link extends Item {
    public static final Pattern MODULE_CODE_PATTERN = Pattern.compile("(^[A-Z]{2,3}[\\d]{4}[A-Z]?$)");
    protected String module;
    protected String type;
    protected String url;

    /**
     * Constructor used when adding a new Zoom link.
     *
     * @param module the name of the module.
     * @param type the type of the zoom link.
     * @param url the Zoom link.
     */
    public Link(String module, String type, String url) throws DukeException {
        super(url);//this is weird
        this.module = module;
        this.type = type;
        this.url = url;
        Matcher matcher = MODULE_CODE_PATTERN.matcher(module);

        if (!matcher.find()) {
            throw new DukeException("~Error~ Format of the module name is incorrect.");
        }
    }

    public String getModule() {
        return this.module;
    }

    public  String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        String returnString = this.getModule() + " " + this.getType() + "\n       " + this.getUrl();
        return returnString;
    }

    public String toFile() {
        String returnString = this.getModule() + " | " + this.getType() + " | " + this.getUrl();
        return returnString;
    }
}
