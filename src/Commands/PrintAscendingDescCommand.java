package Commands;

import Data.Receiver;

/**
 *  Команда print_field_ascending_description
 */
public class PrintAscendingDescCommand extends Command {

    public PrintAscendingDescCommand(Receiver receiver) {
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
                receiver.printFieldAscendDesc();
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
        return "Вывести значения всех элементов поля description в порядке возрастания.";
    }

    @Override
    public String commandName() {
        return "print_field_ascending_description";
    }
}
