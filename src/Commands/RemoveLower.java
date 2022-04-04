package Commands;

import App.CollectionManager;
import java.util.Scanner;

public class RemoveLower implements ICommand{
    private final CollectionManager collectionManager;
    public RemoveLower(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        Input vInput = new Input(input, silent);
        collectionManager.remove_lower(vInput.resultElement(collectionManager.getNewId()));
    }

    @Override
    public String toString() {
        return "add_if_max {element} - Add a new element to the collection if its value is greater than the value of the largest element in this collection";
    }

}
