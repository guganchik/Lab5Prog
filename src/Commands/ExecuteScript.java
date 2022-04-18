package Commands;

import App.CollectionManager;
import App.CommandsList;
import Checker.ExecuteScriptFileNames;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Команда ExecuteScript
 */
public class ExecuteScript implements ICommand{
    private final CollectionManager collectionManager;
    private final CommandsList commandsList;
    private final ExecuteScriptFileNames checkPath = new ExecuteScriptFileNames();

    public ExecuteScript(CommandsList commandsList, CollectionManager collectionManager) {
        this.commandsList = commandsList;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(Scanner input, String[] args, boolean silent) {

        try {
            String filename = args[0];
            Path path = Paths.get(filename);
            Path pathAbs = path.toAbsolutePath();
            if (!silent) {
                checkPath.clearList();
            }

            if (checkPath.checkPath(pathAbs)) {
                System.out.println("Calling scripts is looped!");
                exit(0);
            }


            Scanner finput = new Scanner(path);

            while (finput.hasNext()) {
                String command = finput.nextLine();
                commandsList.execute(finput, command, true);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            if(!silent){
                System.out.println("Invalid input! filename not entered");
            }
        }
        catch (IOException e) {
            if(!silent) {
                System.out.println("Couldn't find script file!");
            }
        }
        catch (Exception e) {
            if(!silent) {
                System.out.println("oops, uncorrect script");
            }
        }

    }
@Override
public String toString() {
    return "execute_script file_name - Read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode";
}

}
