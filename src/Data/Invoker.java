package Data;

import Commands.*;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * По паттерну "команда"
 * Класс, вызывающий команды
 */
public class Invoker {

    private Scanner scanner = new Scanner(System.in);
    private Receiver receiver;
    private HashMap<String,Command> commandsName = new HashMap<String,Command>();

    /**
     * стандартный конструктор, устанавливающий экземпляр ресивера и инициализирующий коллекцию команд
     * @param receiver
     */
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
     * Метод, вызывающий команду, соответсвующую пользовательскому вводу
     */
    public void input(){
        System.out.println("Введите команду:");
        String string = null;
        try {
            string = scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("Why are you so cruel...");
            System.exit(0);
        }
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

    /**
     * Метод, использующийся для работы команды execute_script
     * @param commandLine
     */
    public void execute(String commandLine){
        String[] input = commandLine.split("\\s+");
        String[] arguments = new String[input.length-1];
        System.arraycopy(input, 1, arguments, 0, arguments.length);
        if (commandsName.containsKey(input[0])){
            commandsName.get(input[0]).execute(arguments);
        } else {
            System.out.println("Такой команды не существует. Проверьте правильность ввода команды в скрипте.");
        }

    }

    /**
     * Метод, инициализирующий коллекцию HashMap, с ключом - командой в строковом представлении,
     * и со значением - экземпляр команды
     */
    private void addCommandsNames(){
        commandsName.put(new HelpCommand(receiver).commandName(), new HelpCommand(receiver));
        commandsName.put(new InfoCommand(receiver).commandName(),new InfoCommand(receiver));
        commandsName.put(new ShowCommand(receiver).commandName(),new ShowCommand(receiver));
        commandsName.put(new InsertCommand(receiver).commandName(),new InsertCommand(receiver));
        commandsName.put(new UpdateCommand(receiver).commandName(), new UpdateCommand(receiver));
        commandsName.put(new RemoveKeyCommand(receiver).commandName(), new RemoveKeyCommand(receiver));
        commandsName.put(new ClearCommand(receiver).commandName(),new ClearCommand(receiver));
        commandsName.put(new SaveCommand(receiver).commandName(),new SaveCommand(receiver));
        commandsName.put(new ExecuteScriptCommand(receiver).commandName(), new ExecuteScriptCommand(receiver));
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
