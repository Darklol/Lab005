package Commands;

import Data.Receiver;

/**
 *  Команда exit
 */
public class ExitCommand extends Command {

    public ExitCommand(Receiver receiver) {
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
                receiver.exit();
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
        return "Завершить программу (без сохранения в файл).";
    }

    @Override
    public String commandName() {
        return "exit";
    }
}
