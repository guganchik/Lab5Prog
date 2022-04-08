package Commands;

import App.CollectionManager;
import App.CommandsList;
import Collections.VehicleType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * Команда ExecuteScript
 */
public class ExecuteScript implements ICommand{
    private final CollectionManager collectionManager;
    private final CommandsList commandsList;

    public ExecuteScript(CommandsList commandsList, CollectionManager collectionManager) {
        this.commandsList = commandsList;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(Scanner input, String[] args, boolean silent) {
        String filename = args[0];
        try {
            Path path = Paths.get(filename);
            Scanner finput = new Scanner(path);

            while (finput.hasNext()) {
                String command = finput.nextLine();
                commandsList.execute(finput, command, true);
            }
        } catch (Exception e) {
            System.out.println("Couldn't find script file!");
        }

    }
@Override
public String toString() {
    return "execute_script file_name - Read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode";
}

}
