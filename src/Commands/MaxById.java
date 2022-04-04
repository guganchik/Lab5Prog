package Commands;

import App.CollectionManager;
import java.util.Scanner;

public class MaxById implements ICommand{

    private final CollectionManager collectionManager;

    public MaxById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        collectionManager.max_by_id();
    }

    @Override
    public String toString() {
        return "add {element} - Add a new element to the collection";
    }

}

