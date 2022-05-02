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
        if(collectionManager.remove_greater(vInput.resultElement(collectionManager.getNewId()))){
            if(!silent){System.out.println("Operation success (RemoveGreater)");}
        } else {
            if(!silent){System.out.println("Operation error (RemoveGreater)");}
        }
    }

    @Override
    public String toString() {
        return "remove_greater {element} - Remove from the collection all elements greater than the given";
    }

}
