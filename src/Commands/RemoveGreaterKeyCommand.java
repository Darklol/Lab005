package Commands;

import Data.Receiver;

/**
 *  Команда remove_if_greater_key
 */
public class RemoveGreaterKeyCommand extends Command {

    public RemoveGreaterKeyCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute(String[] arguments) {
        if (arguments.length >= needArguments()) {
            if (arguments.length > needArguments()) {
                System.out.println("Введено больше аргументов, чем требуется команде. " +
                        "(Требуется: " + needArguments() + ").\nВсе остальные аргументы будут проигнорированы.");
            }
            try {
                receiver.removeGreaterKey(Long.parseLong(arguments[0]));
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильный ввод аргумента!");
            }
        } else {
            System.out.println("Недостаточно аргументов для выполнения команды! " +
                    "(Требуемое количество: " + needArguments() + ")");
        }
    }

    @Override
    public int needArguments() {
        return 1;
    }

    @Override
    public String manual() {
        return "Удалить из коллекции все элементы, ключ которых превышает заданный.";
    }

    @Override
    public String commandName() {
        return "remove_greater_key";
    }
}
