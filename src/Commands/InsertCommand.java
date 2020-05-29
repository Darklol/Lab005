package Commands;

import Data.Receiver;

/**
 *  Команда insert
 */
public class InsertCommand extends Command {

    public InsertCommand(Receiver receiver) {
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
                receiver.insert(Long.parseLong(arguments[0]));
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
        return "Добавить новый элемент с заданным ключом.";
    }

    @Override
    public String commandName() {
        return "insert";
    }


}
