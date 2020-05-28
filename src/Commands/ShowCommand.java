package Commands;

import Data.Receiver;

public class ShowCommand extends Command {

    public ShowCommand(Receiver receiver) {
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
                receiver.show();
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
        return "Вывести все элементы коллекции в строковом представлении.";
    }

    @Override
    public String commandName() {
        return "show";
    }
}
