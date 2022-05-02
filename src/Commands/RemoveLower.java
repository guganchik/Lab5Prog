package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда RemoveLower
 */
public class RemoveLower implements ICommand{
    private final CollectionManager collectionManager;
    public RemoveLower(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        Input vInput = new Input(input, silent);
        if(collectionManager.remove_lower(vInput.resultElement(collectionManager.getNewId()))){
            if(!silent){System.out.println("Operation success (RemoveLower)");}
        } else {
            if(!silent){System.out.println("Operation error (RemoveLower)");}
        }
    }

    @Override
    public String toString() {
        return "remove_lower {element} - Remove from the collection all elements smaller than the given one";
    }

}
