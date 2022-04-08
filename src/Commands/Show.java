package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда Show
 */
public class Show implements ICommand {
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public void execute(Scanner input, String args[], boolean silent) {
        collectionManager.show();
    }

    @Override
    public String toString() {
        return "show - Print to standard output all elements of the collection in string representation";
    }
}
