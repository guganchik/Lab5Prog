package Commands;

import App.CollectionManager;
import java.util.Scanner;
/**
 * Команда Update
 */
public class Update implements ICommand{

    private final CollectionManager collectionManager;
    public Update(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(Scanner input, String args[], boolean silent) {
        try {
            final Integer id = Integer.parseInt(args[0]);
            if (!this.collectionManager.update_by_id(id)) {
                System.out.println("Object with id = " + id + " not found!");
            } else {
                Input vInput = new Input(input, silent);
                collectionManager.add(vInput.resultElement(collectionManager.getNewId()));
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input! id not entered or entered incorrectly");
        }
    }

    @Override
    public String toString() {
        return "update id {element} - Update the value of the collection element whose id is equal to the given one";
    }
}
