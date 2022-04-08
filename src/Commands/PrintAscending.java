package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда PrintAscending
 */
public class PrintAscending implements ICommand{
    private final CollectionManager collectionManager;

    public PrintAscending(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public void execute(Scanner input, String args[], boolean silent) {
        collectionManager.print_ascending();
    }

    @Override
    public String toString() {
        return "print_ascending - Display the elements of the collection in ascending order";
    }
}
