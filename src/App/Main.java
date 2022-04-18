package App;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String args[]) {
        System.out.println("Usage for launching Lab5:  java -jar Lab5.jar filename");
        System.out.println("Argument values:");
        System.out.println("filename - path to file where vechicle items will be saved, for example ./storage.csv");


        if (null == args || args.length == 0) {
            System.out.println("Error! Path to storage file was not specified!");
            return;
        } else {
            Path path = Paths.get(args[0]);
            File file = new File(String.valueOf(path));
            if (Files.exists(path)&&(!file.canRead() || !file.canWrite())) {
                System.out.println("Permission denied");
                System.exit(1);
            }
            if (Files.isDirectory(path)) {
                System.out.println("Error! Path to storage can't be a directory!");
                return;
            } else {
                if (Files.exists(path)) {
                    System.out.println("Using existing storage file: " + args[0]);
                } else {
                    System.out.println("Storage file doesn't exist, using empty");
                }

            }
        }

        Scanner input = new Scanner(System.in);
        CommandsList commandsList = new CommandsList(args[0]);

        try {
            while (true) {
                System.out.print("Enter command: ");
                String command = input.nextLine();
                commandsList.execute(input, command, false);
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("exit program");
            return;
        }
    }
}
