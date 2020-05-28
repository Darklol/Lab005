package Data;

import Commands.Command;
import Commands.InsertCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс, вызывающий команды и производящий логирование (TBD)
 */
public class Invoker {

    private Scanner scanner = new Scanner(System.in);
    private Receiver receiver;
    private HashSet<Command> commands= new HashSet<Command>();
    private HashMap<String,Command> commandsName = new HashMap<String,Command>();

    public Invoker(Receiver receiver){
        this.receiver = receiver;
        System.out.println("Welcome, user!");
        addCommandsNames();
    }

    public void input(){
        System.out.println("Введите команду:");
        String string = scanner.nextLine().trim();
        Scanner tempScanner = new Scanner(string);
        String[] input = string.split("\\s+");
        String[] arguments = new String[input.length-1];
        System.arraycopy(input, 1, arguments, 0, arguments.length);
        if (commandsName.containsKey(input[0])){
            commandsName.get(input[0]).execute(arguments);
        }
    }

    public void execute(Command command){
        Scanner scanner = new Scanner(System.in);
        String[] string = new String[]{"1","2","3"};
        command.execute(string);
    }

    private void addCommandsNames(){
//        commandsName.add("help");
//        commandsName.add("info");
//        commandsName.add("show");
        commandsName.put("insert",new InsertCommand(receiver));
//        commandsName.add("update");
//        commandsName.add("remove_key");
//        commandsName.add("clear");
//        commandsName.add("save");
//        commandsName.add("execute_script");
//        commandsName.add("exit");
//        commandsName.add("remove_greater");
//        commandsName.add("replace_if_greater");
//        commandsName.add("remove_greater_key");
//        commandsName.add("min_by_name");
//        commandsName.add("print_unique_killer");
//        commandsName.add("print_field_ascending_description");

    }
}
