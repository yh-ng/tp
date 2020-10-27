package seedu.duke.task;

import seedu.duke.common.Messages;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class LinkList extends ItemList<Link> {
    private ArrayList<Link> links;

    public LinkList() {
        links = new ArrayList<>();
    }

    @Override
    public void addTodo(String description) {

    }

    public LinkList(ArrayList<Link> links) {
        this.links = links;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
        Ui.dukePrint(Messages.MESSAGE_ADD_LINK + link.linkToString() + Messages.MESSAGE_LINK_STATUS_FIRST
                + links.size() + Messages.MESSAGE_LINK_STATUS_LAST);
    }

    public int size() {
        return links.size();
    }

    public Link get(int i) {
        return links.get(i);
    }

    public void listLink() {
        String message = "";
        if (links.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LIST);
            return;
        }
        for (int i = 0; i < links.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + links.get(i).linkToString();
        }
        Ui.dukePrint(Messages.MESSAGE_LIST + message);
    }
}
