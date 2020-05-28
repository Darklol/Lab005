package Commands;

import Data.Receiver;

public class PrintUniqueKillerCommand extends Command {

    public PrintUniqueKillerCommand(Receiver receiver) {
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
                receiver.printUniqueKiller();
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
        return 0;
    }

    @Override
    public String manual() {
        return "Вывести уникальные значения поля killer всех элементов коллекции.";
    }

    @Override
    public String commandName() {
        return "print_unique_killer";
    }
}
