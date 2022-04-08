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
        collectionManager.save();
    }

    @Override
    public String toString() {
        return "save - Save collection to file";
    }

}
