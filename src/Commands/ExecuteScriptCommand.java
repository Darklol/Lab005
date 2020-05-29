package Commands;

import Data.Receiver;

import java.io.IOException;

public class ExecuteScriptCommand extends Command{
    public ExecuteScriptCommand(Receiver receiver) {
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
                    receiver.executeScript(arguments[0]);
                } catch (IOException e) {
                    System.out.println("Файл не найден!");
                }
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
        return "Считать и исполнить скрипт из указанного файла.";
    }

    @Override
    public String commandName() {
        return "execute_script";
    }


}

