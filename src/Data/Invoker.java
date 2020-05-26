package Data;

import Commands.Command;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс, вызывающий команды и производящий логирование (TBD)
 */
public class Invoker {

    private Scanner scanner = new Scanner(System.in);
    private Receiver receiver;
    private HashSet<Command> commands= new HashSet<Command>();
    private HashSet<String> commandsName = new HashSet<String>();

    public Invoker(Receiver receiver){
        System.out.println("Welcome, user!");
        addCommandsNames();
        scanner.nextLine();

    }

    public void execute(Command command){

        command.execute();
    }

    private void addCommandsNames(){
        commandsName.add("help");
        commandsName.add("info");
        commandsName.add("show");
        commandsName.add("insert");
        commandsName.add("update");
        commandsName.add("remove_key");
        commandsName.add("clear");
        commandsName.add("save");
        commandsName.add("execute_script");
        commandsName.add("exit");
        commandsName.add("remove_greater");
        commandsName.add("replace_if_greater");
        commandsName.add("remove_greater_key");
        commandsName.add("min_by_name");
        commandsName.add("print_unique_killer");
        commandsName.add("print_field_ascending_description");

    }
}
