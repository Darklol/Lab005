package Commands;

import Data.Receiver;

/**
 *  Команда replace_if_greater
 */
public class ReplaceIfGreaterCommand extends Command {

    public ReplaceIfGreaterCommand(Receiver receiver) {
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
                receiver.replaceGreater(Long.parseLong(arguments[0]));
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
        return "Заменить значение по ключу, если новое значение больше старого.";
    }

    @Override
    public String commandName() {
        return "replace_if_greater";
    }
}
