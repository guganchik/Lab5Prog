package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда Clear
 */
public class Clear implements ICommand{

    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute (Scanner input, String args[], boolean silent){

        if (collectionManager.clear() && !silent) {
            if(!silent){System.out.println("Operation success (Clear)");}
        } else {
            if(!silent){System.out.println("Operation error (Clear)");}
        }
    }

    @Override
    public String toString() {
        return "clear - Clear the collection";
    }

}
