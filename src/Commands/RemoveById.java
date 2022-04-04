package Commands;

import App.CollectionManager;
import java.util.Scanner;

public class RemoveById implements ICommand {
    private final CollectionManager collectionManager;


    public RemoveById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public void execute(Scanner input, String args[], boolean silent) {
        try {
            final Integer id = Integer.parseInt(args[0]);
            if (!this.collectionManager.remove_by_id(id)) {
                System.out.println("Object with id = " + id + " not found!");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input! id not entered or entered incorrectly");
        }
    }

    @Override
    public String toString() {
        return "remove_by_id id - Remove element from collection by its id";
    }
}
