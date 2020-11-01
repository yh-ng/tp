package seedu.duke.model.item;

public class Link extends Item {
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
    public Link(String module, String type, String url) {
        super(url);//this is weird
        this.module = module;
        this.type = type;
        this.url = url;
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
