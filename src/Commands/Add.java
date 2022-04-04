package Commands;

import App.CollectionManager;
import Collections.Coordinates;
import Collections.Vehicle;
import Collections.VehicleType;
import java.util.Scanner;

public class Add implements ICommand{
    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        Input vInput = new Input(input, silent);
        collectionManager.add(vInput.resultElement(collectionManager.getNewId()));
    }

    @Override
    public String toString() {
        return "add {element} - Add a new element to the collection";
    }
}

