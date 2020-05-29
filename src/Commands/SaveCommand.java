package Commands;

import Data.Receiver;

import java.io.IOException;

/**
 *  Команда save
 */
public class SaveCommand extends Command{
    public SaveCommand(Receiver receiver) {
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
                try {
                    receiver.save();
                } catch (IOException e) {
                    System.out.println("Не удалось создать файл. Возможно, не хватает прав на запись в директории.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Коллекция повреждена! Сохранение невозможно.");
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
        return "Сохранить коллекцию в файл.";
    }

    @Override
    public String commandName() {
        return "save";
    }
}
