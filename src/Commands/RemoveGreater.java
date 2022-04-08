package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда RemoveGreater
 */
public class RemoveGreater implements ICommand {
    private final CollectionManager collectionManager;
    public RemoveGreater(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        Input vInput = new Input(input, silent);
        collectionManager.remove_greater(vInput.resultElement(collectionManager.getNewId()));
    }

    @Override
    public String toString() {
        return "remove_greater {element} - Remove from the collection all elements greater than the given";
    }

}
