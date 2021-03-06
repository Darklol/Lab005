package Commands;

import Data.Receiver;

/**
 *  Абстрактный класс Команда
 *  Описывает общее поведение всех команд
 */
public abstract class Command {
    /**
     * абстрактный класс команды
     * определяет общее поведение всех команд
     */
    public Receiver receiver;

    public abstract void execute(String[] arguments);

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Метод, который показывает, сколько аргуметов требуется команду
     *
     * @return
     */
    public abstract int needArguments();

    /**
     * Метод возвращающий описание команды
     * Нужен для команды help
     *
     * @return
     */
    public abstract String manual();

    /**
     * Метод, возвращающий строковое имя команды
     *
     * @return
     */
    public abstract String commandName();


}
