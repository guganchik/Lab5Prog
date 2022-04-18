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
        collectionManager.clear();
        if(!silent){
            System.out.println("Cleared the collection");
        }
    }

    @Override
    public String toString() {
        return "clear - Clear the collection";
    }

}
