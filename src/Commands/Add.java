package Commands;

import App.CollectionManager;
import Collections.Coordinates;
import Collections.Vehicle;
import Collections.VehicleType;
import java.util.Scanner;

/**
 * Команда Add
 */
public class Add implements ICommand{
    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        Input vInput = new Input(input, silent);
        if (collectionManager.add(vInput.resultElement(collectionManager.getNewId()))) {
            if(!silent){System.out.println("Operation success (Add)");}
        } else {
            if(!silent){System.out.println("Operation error (Add)");}
        }
    }

    @Override
    public String toString() {
        return "add {element} - Add a new element to the collection";
    }
}

