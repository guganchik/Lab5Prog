package App;

import Commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс, который хранит все возможные команды и вызывает их по ключу.
 */
public class CommandsList {
    public static final HashMap<String, ICommand> commands = new HashMap<>();
    private CollectionManager collectionManager;
    private String filename;
    

    public CommandsList(String filename) {
        this.filename = filename;
        CollectionManager collectionManager = new CollectionManager(filename);
        commands.put("help", new Help());
        commands.put("exit", new Exit());
        commands.put("add_if_max", new AddIfMax(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("max_by_id", new MaxById(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("remove_greater", new RemoveGreater(collectionManager));
        commands.put("remove_lower", new RemoveLower(collectionManager));
        commands.put("update", new Update(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("add", new Add(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("filter_greater_than_type", new FilterGreaterThanType(collectionManager));
        commands.put("print_ascending", new PrintAscending(collectionManager));
        commands.put("execute_script", new ExecuteScript(this, collectionManager));
    }

    public void execute(Scanner input, String command, boolean silent) {

        String commandCut[] = command.trim().split("\\s+");
        String commandName = commandCut[0];
        String args[] = Arrays.copyOfRange(commandCut, 1, commandCut.length);

        if (commands.containsKey(commandName)) {
            commands.get(commandName).execute(input, args, silent);
        } else {
            System.out.println("Enter the command again!");
        }
    }
}
