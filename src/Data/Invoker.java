package Data;

import Commands.*;

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
    private HashMap<String,Command> commandsName = new HashMap<String,Command>();

    public Invoker(Receiver receiver){
        this.receiver = receiver;
        addCommandsNames();
    }

    /**
     * пустой конструктор, нужен для работы команды help
     */
    public Invoker(){
        addCommandsNames();
    };

    /**
     * Метод, отвечающий вызывающий команду, соответсвующую пользовательскому вводу
     */
    public void input(){
        System.out.println("Введите команду:");
        String string = scanner.nextLine().trim();
        String[] input = string.split("\\s+");
        String[] arguments = new String[input.length-1];
        System.arraycopy(input, 1, arguments, 0, arguments.length);
        if (commandsName.containsKey(input[0])){
            commandsName.get(input[0]).execute(arguments);
        } else {
            System.out.println("Такой команды не существует. Проверьте правильность ввода команды.");
            System.out.println();
        }
    }

    private void addCommandsNames(){
        commandsName.put(new HelpCommand(receiver).commandName(), new HelpCommand(receiver));
        commandsName.put(new InfoCommand(receiver).commandName(),new InfoCommand(receiver));
        commandsName.put(new ShowCommand(receiver).commandName(),new ShowCommand(receiver));
        commandsName.put(new InsertCommand(receiver).commandName(),new InsertCommand(receiver));
        commandsName.put(new UpdateCommand(receiver).commandName(), new UpdateCommand(receiver));
        commandsName.put(new RemoveKeyCommand(receiver).commandName(), new RemoveKeyCommand(receiver));
        commandsName.put(new ClearCommand(receiver).commandName(),new ClearCommand(receiver));
//        commandsName.add("save");
//        commandsName.add("execute_script");
        commandsName.put(new ExitCommand(receiver).commandName(),new ExitCommand(receiver));
        commandsName.put(new RemoveGreaterKeyCommand(receiver).commandName(),new RemoveGreaterKeyCommand(receiver));
        commandsName.put(new ReplaceIfGreaterCommand(receiver).commandName(),new ReplaceIfGreaterCommand(receiver));
        commandsName.put(new RemoveGreaterCommand(receiver).commandName(),new RemoveGreaterCommand(receiver));
        commandsName.put(new MinByNameCommand(receiver).commandName(),new MinByNameCommand(receiver));
        commandsName.put(new PrintUniqueKillerCommand(receiver).commandName(),new PrintUniqueKillerCommand(receiver));
        commandsName.put(new PrintAscendingDescCommand(receiver).commandName(),new PrintAscendingDescCommand(receiver));
    }

    public HashMap<String, Command> getCommandsName() {
        return commandsName;
    }
}
