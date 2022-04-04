package Commands;

import App.CollectionManager;
import App.CommandsList;
import Collections.VehicleType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
                //System.out.println(command);
                commandsList.execute(finput, command, true);
            }
            
            
            //System.out.println("args: " + args[0]);
            
            //collectionManager.execute_script(filename);
        } catch (Exception e) {
            System.out.println("TODO");
        }

    }
    

/**    
    public void execute_script(String filename) {
        Path path = Paths.get(filename);
        try {
            Scanner input = new Scanner(path);

            while (true) {
                String command = input.nextLine();
                System.out.println(command);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
*/    
    
    
    


}
