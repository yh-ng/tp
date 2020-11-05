package seedu.duke.model.itemlist;

import seedu.duke.model.item.Credit;

import java.util.ArrayList;

public class CreditList extends ItemList<Credit> {

    /**
     * Constructs a task list with the given tasks.
     *
     * @param mealCredit an ArrayList of tasks
     */
    public CreditList(ArrayList<Credit> mealCredit) {
        this.items = mealCredit;
    }

    /**
     * Constructs an empty task list.
     */
    public CreditList() {
        items = new ArrayList<>();
    }



    @Override
    public void addTodo(String description) {

    }
}
