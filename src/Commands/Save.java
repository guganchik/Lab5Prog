package Commands;

import App.CollectionManager;
import App.Storage;
import java.util.Scanner;
/**
 * Команда Save
 */
public class Save implements ICommand {

    private final CollectionManager collectionManager;
    
    public Save(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        if(collectionManager.save()){
            if(!silent){System.out.println("Operation success (Save)");}
        } else {
            if(!silent){System.out.println("Operation error (Save)");}
        }
    }

    @Override
    public String toString() {
        return "save - Save collection to file";
    }

}
