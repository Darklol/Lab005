package Commands;

import Data.Receiver;

public class ClearCommand extends Command {

    public ClearCommand(Receiver receiver) {
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
                receiver.clear();
            } catch (IllegalArgumentException e) {
                System.out.println("Неправильный ввод аргумента! Попробуйте ввести другой аргумент.");
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
        return "Очистить коллекцию.";
    }

    @Override
    public String commandName() {
        return "clear";
    }
}
