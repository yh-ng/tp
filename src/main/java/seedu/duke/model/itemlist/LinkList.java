// @@author Cao-Zeyu

package seedu.duke.model.itemlist;

import seedu.duke.Duke;
import seedu.duke.DukeException;
import seedu.duke.common.Messages;
import seedu.duke.model.item.Book;
import seedu.duke.model.item.Link;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class LinkList extends ItemList<Link> {
    private ArrayList<Link> links;

    /**
     * Constructs an empty link list.
     */
    public LinkList() {
        links = new ArrayList<>();
    }

    @Override
    public void addTodo(String description) {
    }

    /**
     * Constructs a link list with the given links.
     *
     * @param links An ArrayList of {@code Link}.
     */
    public LinkList(ArrayList<Link> links) {
        this.links = links;
    }

    /**
     * Retrieves the list of links.
     *
     * @return An ArrayList of {@code Link}.
     */
    public ArrayList<Link> getLinks() {
        return links;
    }

    /**
     * Clears all the links in the list.
     */
    public void clearList() {
        links = new ArrayList<>();

    }

    /**
     * Adds a link to the link list.
     *
     * @param link the link to be added in to the list.
     */
    public void addLink(Link link) throws DukeException {
        checkLinkAlreadyExists(link);
        links.add(link);
        Ui.dukePrint(Messages.MESSAGE_ADD_LINK + link.toString() + Messages.MESSAGE_STATUS_FIRST
                + links.size() + Messages.MESSAGE_LINK_STATUS_LAST);
    }

    /**
     * Retrieves the size of the link list.
     *
     * @return the size of the link list
     */
    public int size() {
        return links.size();
    }

    /**
     * Retrieves the i-th link in the link list.
     *
     * @param i the index of the desired link.
     * @return the i-th link in the link list.
     */
    public Link get(int i) {
        return links.get(i);
    }

    /**
     * Lists all the links in the link list.
     */
    public void listLink() {
        String message = "";
        if (links.size() == 0) {
            Ui.dukePrint(Messages.MESSAGE_EMPTY_LINK_LIST);
            return;
        }
        for (int i = 0; i < links.size(); i++) {
            message = message + "\n     " + (i + 1) + "." + links.get(i).toString();
        }
        Ui.dukePrint(Messages.MESSAGE_LINK_LIST + message);
    }

    /**
     * Deletes a link from the list, identified by the index of the link in the list.
     *
     * @param index the index of the link in the list.
     */
    public void deleteLink(int index) {
        if (index > links.size() || index < 1) {
            Ui.dukePrint(Messages.WARNING_NO_LINK);
        } else {
            Link linkRemoved = links.get(index - 1);
            Ui.dukePrint(Messages.MESSAGE_DELETE_LINK + linkRemoved.toString() + Messages.MESSAGE_STATUS_FIRST
                    + (links.size() - 1) + Messages.MESSAGE_LINK_STATUS_LAST);
            links.remove(index - 1);
        }
    }

    private void checkLinkAlreadyExists(Link link) throws DukeException {
        int count = (int) links.stream()
                .filter(existingLink -> existingLink.getModule().equals(link.getModule()))
                .filter(existingLink -> existingLink.getType().equals(link.getType()))
                .count();
        if (count != 0) {
            throw new DukeException("~Error~ Link of this lesson already exists!");
        }
    }
}
