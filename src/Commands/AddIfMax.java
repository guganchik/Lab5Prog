package Commands;

import App.CollectionManager;
import Collections.Coordinates;
import Collections.Vehicle;
import Collections.VehicleType;
import java.util.Scanner;
/**
 * Команда AddIfMax
 */
public class AddIfMax implements ICommand {

    private final CollectionManager collectionManager;
    
    public AddIfMax(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
       Input vInput = new Input(input, silent);
        if(collectionManager.add_if_max(vInput.resultElement(collectionManager.getNewId()))){
            if(!silent){System.out.println("Operation success (AddIfMax)");}
        } else {
            if(!silent){System.out.println("Operation error (AddIfMax)");}
        }
    }

    @Override
    public String toString() {
        return "add_if_max {element} - Add a new element to the collection if its value is greater than the value of the largest element in this collection";
    }

}
